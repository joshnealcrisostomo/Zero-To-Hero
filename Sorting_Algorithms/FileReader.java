package Sorting_Algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    /*
     * This function reads a file from the given path, and
     * returns an array of Record objects representing the
     * data that was read.
     */
    public Record[] readFile(String path) {
        try {
            File f = new File(path);
            Scanner scanner = new Scanner(f);
            int n = scanner.nextInt(); // Get the number of records
            Record[] result = new Record[n]; // Initialize array of records
            for (int i = 0; i < n; i++) { // Loop through each record
                int idNumber = scanner.nextInt(); // get the ID number
                String name = scanner.nextLine(); // get the name
                Record record = new Record(name, idNumber); // instantiate a new Record object
                result[i] = record; // Store the record in the array
            }
            scanner.close();
            return result;
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            e.printStackTrace();
            return null;
        }
    }
}
