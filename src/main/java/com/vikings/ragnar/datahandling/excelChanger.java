package com.vikings.ragnar.datahandling;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class excelChanger {

    public static void writeToCsv(Sheet sheet, String path) {
        System.out.println("Writing to CSV...");


        path = path.substring(0,path.length()-4) + "csv";

        System.out.println(path);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), "utf-8"))) {

            Row row = null;
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                String line = "";

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    if(j == row.getLastCellNum()-1){
                        System.out.println(row.getCell(j));
                        line+= row.getCell(j);
                        // row = baseDataEntity
                        // new BaseDataEntity(getCell(0),getCell(1))
                    }
                    else{
                        line += row.getCell(j) + ",";
                    }

                }
                line += "\n";
                writer.write(line);
            }
            writer.close();
            System.out.println("Converted Successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void excelFileHandler(String path){
        InputStream inp = null;
        try {
            inp = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(inp);

            for(int i=0;i<wb.getNumberOfSheets();i++) {
                if(wb.getSheetAt(i).getSheetName().equals("Base Data")){
                    writeToCsv(wb.getSheetAt(i), path);
                }
            }
        } catch (InvalidFormatException ex) {
            Logger.getLogger(excelChanger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(excelChanger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(excelChanger.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inp.close();
            } catch (IOException ex) {
                Logger.getLogger(excelChanger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }



}


