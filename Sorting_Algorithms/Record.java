package Sorting_Algorithms;

/* This is a class to represent a single record.
 * You are NOT allowed to modify this class.
 */

public class Record {
    private String name; // The name of the person
    private int idNumber; // The ID number of the person

    public Record(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    /* Getters */
    public String getName() {
        return name;
    }

    public int getIdNumber() {
        return idNumber;
    }

    /*
     * This class has intentionally no setters to
     * prevent modification of the data once initialized.
     */
}
