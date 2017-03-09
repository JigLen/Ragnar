package com.vikings.ragnar.datahandling;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by carlmccann2 on 09/02/2017.
 *
 * Watches the directory where new data to be imported will be dropped. This will automate cleaning, insertion etc.
 */
public class DataCleaner {
    public static void clean(String fileName){
        System.out.println("Cleaning: " + fileName);
        // for testing originally, now taken in via arg
        // String fileName = "res/base_data/base_data_empty_null_field.csv";
        File file = new File(fileName);
        File tempFile = new File(fileName + ".tmp");

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));

            PrintWriter writer = new PrintWriter(tempFile,"UTF-8");
            String line;

            boolean pastLineOne = false;
            while ((line = br.readLine()) != null) {
                String line_split[] = line.split(",");

                if(pastLineOne){
                    // replaces any empty or (null) fields with \N
                    for (int i = 0; i < line_split.length ; i++) {
                        if(line_split[i].equals("") || line_split[i].equals("(null)")){
                            line_split[i] = "\\N";
                        }
                    }

                    // Date/Time formatting
                    String dateSplit[] = line_split[0].split("/");

                    if(dateSplit.length == 3){
                        String yearTimeSplit[] = dateSplit[2].split(" ");
                        String mysqlDateTimeFormat = yearTimeSplit[0] + "-" + dateSplit[1]
                                + "-" + dateSplit[0] + " " + yearTimeSplit[1];
                        line_split[0] = mysqlDateTimeFormat;
                    }
                }
                else{
                    pastLineOne = true;
                }

                // rewrite
                for (int i = 0; i < line_split.length ; i++) {
                    if (i == line_split.length-1){
                        writer.println(line_split[i]);
                    }
                    else{
                        writer.print(line_split[i] + ",");
                    }
                }
            }

            writer.close();
            br.close();
            file.delete();

            tempFile.renameTo(file);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void main(String[] args) {
//        //clean();
//        clean("res/base_data.csv");
//    }
}
