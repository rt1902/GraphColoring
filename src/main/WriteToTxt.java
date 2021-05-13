package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToTxt {
    public static void writeToFile(List<String[]> data, String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);

            for (String[] arr: data){
                StringBuilder line = new StringBuilder();
                for (String str : arr) {
                    line.append(str).append(" ");
                }
                myWriter.write(line.toString() + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
