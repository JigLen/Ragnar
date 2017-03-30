package com.vikings.ragnar.datahandling;

import com.vikings.ragnar.daos.BaseDataDao;
import com.vikings.ragnar.entities.BaseDataEntity;

import javax.ejb.EJB;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by carlmccann2 on 09/03/2017.
 */
public class csvPersister {
//    static EntityManager entityManager;
    @EJB
    private static BaseDataDao baseDataDao;

    public static void persist(String fileName){
        File file = new File(fileName);

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            boolean pastLineOne = false;
            while ((line = br.readLine()) != null) {
                String line_split[] = line.split(",");

                if(pastLineOne){
                    // replaces any empty or (null) fields with \N
                    for (int i = 0; i < line_split.length ; i++) {
                        System.out.println(i + ": " + line_split[i]);
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = null;
                    Integer eventId= null;
                    Integer failureClass= null;
                    String ueType= null;
                    Integer market= null;
                    Integer operator= null;
                    Integer cellId= null;
                    Integer duration= null;
                    Integer causeCode= null;
                    String neVersion= null;
                    Long imsi= null;
                    BigDecimal hier3Id= null;
                    BigDecimal hier32Id= null;
                    BigDecimal hier321Id= null;

                    try {
//                        date = formatter.parse(line_split[0]);

                        eventId = (int)Double.parseDouble(line_split[1]);
                        failureClass = (int)Double.parseDouble(line_split[2]);
                        ueType = line_split[3];
                        market = (int)Double.parseDouble(line_split[4]);
                        operator = (int)Double.parseDouble(line_split[5]);
                        cellId = (int)Double.parseDouble(line_split[6]);
                        duration = (int)Double.parseDouble(line_split[7]);
                        causeCode = (int)Double.parseDouble(line_split[8]);
                        neVersion = line_split[9];
                        hier3Id = BigDecimal.valueOf(Double.parseDouble(line_split[10]));
                        hier32Id = BigDecimal.valueOf(Double.parseDouble(line_split[11]));
                        hier321Id = BigDecimal.valueOf(Double.parseDouble(line_split[12]));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    BaseDataEntity currentRow = new BaseDataEntity(date,eventId,failureClass,ueType,market,operator,cellId,duration,causeCode,neVersion,imsi, hier3Id,hier32Id,hier321Id);
                    baseDataDao.add(currentRow);



//                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb");
//                    entityManager = emf.createEntityManager(); //do some persist-things
//                    entityManager.persist(currentRow);
//                    entityManager.flush();
//                    entityManager.clear();
//                    entityManager.close();
                }
                else{
                    pastLineOne = true;
                }

            }

            br.close();
            file.delete();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
