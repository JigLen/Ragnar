package com.vikings.ragnar.datachanging;
import java.io.*;
//import jxl.*;

import java.util.*;

class datachanger
{
    /*
    public static void main(String[] args)
    {
        try
        {
            //File to store data in form of CSV
            File f = new File("/Users/saharmohamedali/Desktop/data.csv");

            OutputStream os = (OutputStream)new FileOutputStream(f);
            String encoding = "UTF8";
            OutputStreamWriter osw = new OutputStreamWriter(os, encoding);
            BufferedWriter bw = new BufferedWriter(osw);

            //Excel document to be imported
            String filename = "/Users/saharmohamedali/Desktop/Workbook.xls";
            WorkbookSettings ws = new WorkbookSettings();
            ws.setLocale(new Locale("en", "EN"));
            Workbook w = Workbook.getWorkbook(new File(filename),ws);

            // Gets the sheets from workbook
            for (int sheet = 0; sheet < w.getNumberOfSheets(); sheet++)
            {
                Sheet s = w.getSheet(sheet);

                bw.write(s.getName());
                bw.newLine();

                Cell[] row = null;

                // Gets the cells from sheet
                for (int i = 0 ; i < s.getRows() ; i++)
                {
                    row = s.getRow(i);

                    if (row.length > 0)
                    {
                        bw.write(row[0].getContents());
                        for (int j = 1; j < row.length; j++)
                        {
                            bw.write(',');
                            bw.write(row[j].getContents());
                        }
                    }
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e)
        {
            System.err.println(e.toString());
        }
        catch (IOException e)
        {
            System.err.println(e.toString());
        }
        catch (Exception e)
        {
            System.err.println(e.toString());
        }
    }
    */
}