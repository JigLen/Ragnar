package com.vikings.ragnar.datacleaning;

import java.io.*;
import java.util.Arrays;


/**
 * Created by carlmccann2 on 09/02/2017.
 */
public class BaseDataCleaner {
    public static void clean(String fileName){
        System.out.println("Cleaning: " + fileName);
        // for testing originally, now taken in via arg
        // String fileName = "res/base_data/base_data_empty_null_field.csv";
        File file = new File(fileName);

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter writer = new PrintWriter(fileName + ".tmp","UTF-8");
            String line;
            while ((line = br.readLine()) != null) {
                String line_split[] = line.split(",");
                if(line_split[2].equals("")){
                    line_split[2] = "\\N";
                }
                if(line_split[8].equals("")){
                    line_split[8] = "\\N";
                }
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

           String newFileName = "res/base_data/base_data_empty_null_field.csv.tmp";
           file = new File(newFileName);
           file.renameTo(new File(fileName));




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //clean();
    }
}
