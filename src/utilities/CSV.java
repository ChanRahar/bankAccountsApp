package utilities;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CSV {
    //this method will read date from a CSV file and return as a list
    public static List<String[]> read(String file){
        List<String[]> data = new LinkedList<>();

        String dataRow;
        try {
            BufferedReader br = new BufferedReader((new FileReader(file)));

            while((dataRow = br.readLine()) !=null){
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could Not Find File");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could Not Read File");
            e.printStackTrace();
        }

        return data;
    }
}
