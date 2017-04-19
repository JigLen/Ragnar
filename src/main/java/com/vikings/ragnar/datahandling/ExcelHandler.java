package com.vikings.ragnar.datahandling;

import com.vikings.ragnar.entities.*;
import com.vikings.ragnar.entities.embeddable.EventCauseId;
import com.vikings.ragnar.entities.embeddable.MccMncId;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelHandler {
    public static Collection<BaseDataEntity> baseDataPersister(Sheet baseData) {
        System.out.println("Objectifying Data From: " + baseData.getSheetName());
        System.out.println("This includes data type validation");
        System.out.println();
        List<BaseDataEntity> toBePersisted = new ArrayList<>();

        DecimalFormat decimalFormat = new DecimalFormat();

        for (Row row : baseData) {
            if (row.getRowNum() == 0) continue;







            // the if statements within the try come from the fact that the spreadsheet is
            // badly formatted e.g. integer columns have mixed String and numeric values
            // this was written by opening: Group Project - Dataset 2A 2017.xls
            try {
                // Moved the composite key here so a special constructor can be used

                //Col 9 / 14 CauseCode
                Integer causeCode = null;
                if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//                    baseDataEntity.setCauseCode((int)row.getCell(8).getNumericCellValue());
                    causeCode = new Integer((int)row.getCell(8).getNumericCellValue());

                }
                else if(row.getCell(8).getStringCellValue().matches("\\d+")){
//                        baseDataEntity.setCauseCode(new Integer(row.getCell(8).getStringCellValue()));
                        causeCode = new Integer((int)row.getCell(8).getNumericCellValue());
                }


                //Col 2 / 14 eventId
                Integer eventId = new Integer((int)row.getCell(1).getNumericCellValue());

                EventCauseEntity eventCauseEntity = new EventCauseEntity(new EventCauseId(causeCode,eventId));
//                baseDataEntity.setEventId((int) row.getCell(1).getNumericCellValue());


                BaseDataEntity baseDataEntity = new BaseDataEntity();
                baseDataEntity.setEventCauseEntity(eventCauseEntity);

                //Col 1 / 14
                baseDataEntity.setDateTime(new Timestamp(row.getCell(0).getDateCellValue().getTime()));


                //Col 3 / 14 failureClass
                FailureClassEntity failureClassEntity;
                if(row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC){
//                    baseDataEntity.setFailureClass();
                    failureClassEntity = new FailureClassEntity((int) row.getCell(2).getNumericCellValue());
                    baseDataEntity.setFailureClassEntity(failureClassEntity);
                }
                else{
                    if(row.getCell(2).getStringCellValue().equals("(null)")) continue;
//                    baseDataEntity.setFailureClass(new Integer(row.getCell(2).getStringCellValue()));
                    failureClassEntity = new FailureClassEntity(new Integer(row.getCell(2).getStringCellValue()));
                    baseDataEntity.setFailureClassEntity(failureClassEntity);
                }
                //Col 4 / 14 ueType
                UeEntity ueEntity = new UeEntity((int) row.getCell(3).getNumericCellValue());
                baseDataEntity.setUeEntity(ueEntity);
                //Col 5 / 14 market
//                baseDataEntity.setMarket((int) row.getCell(4).getNumericCellValue());
                //Col 6 / 14 operator
//                baseDataEntity.setOperator((int) row.getCell(5).getNumericCellValue());

                MccMncEntity mccMncEntity =
                        new MccMncEntity(new MccMncId((int) row.getCell(4).getNumericCellValue(),
                                (int) row.getCell(5).getNumericCellValue()));

                baseDataEntity.setMccMncEntity(mccMncEntity);



                //Col 7 / 14 cellId
                baseDataEntity.setCellId((int) row.getCell(6).getNumericCellValue());
                //Col 8 / 14 Duration
                baseDataEntity.setDuration((int) row.getCell(7).getNumericCellValue());

                //Col 10 / 14 NeVersion
                baseDataEntity.setNeVersion(row.getCell(9).getStringCellValue());
                //Col 11 / 14 IMSI
                if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC) {

                    baseDataEntity.setImsi((long)(row.getCell(10).getNumericCellValue()));
                } else {
                    baseDataEntity.setImsi((Long) decimalFormat.parse(row.getCell(10).getStringCellValue()));
                }
                //Col 12 / 14 Hier3_ID
                if (row.getCell(11).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    baseDataEntity.setHier3Id(BigDecimal.valueOf(row.getCell(11).getNumericCellValue()));
                } else {
                    baseDataEntity.setHier3Id((BigDecimal) decimalFormat.parse(row.getCell(11).getStringCellValue()));
                }
                //Col 13 / 14 Hier32_ID
                if (row.getCell(12).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    baseDataEntity.setHier32Id(BigDecimal.valueOf(row.getCell(12).getNumericCellValue()));
                } else {
                    baseDataEntity.setHier32Id((BigDecimal) decimalFormat.parse(row.getCell(12).getStringCellValue()));
                }

                //Col 14 / 14 Hier321_ID
                if (row.getCell(13).getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    baseDataEntity.setHier321Id(BigDecimal.valueOf(row.getCell(13).getNumericCellValue()));
                } else {
                    baseDataEntity.setHier321Id((BigDecimal) decimalFormat.parse(row.getCell(13).getStringCellValue()));
                }


                if(!baseDataEntity.isIncomplete()){

                    toBePersisted.add(baseDataEntity);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Entities have been prepared");
        return toBePersisted;
    }

    public static Collection<BaseDataEntity> excelFileHandler(String path) {
        System.out.println("Reading Excel File...");
        InputStream inp = null;
        try {
            inp = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(inp);

            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                if (wb.getSheetAt(i).getSheetName().equals("Base Data")) {
//                    writeToCsv(wb.getSheetAt(i), path);
                    return baseDataPersister(wb.getSheetAt(i));
                }
                else{



                    // do stuff with the reference table data
                }
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    return new ArrayList<>();
    }
}


