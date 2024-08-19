package Sorting_Algorithms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        SortingAlgorithms sortingAlgo = new SortingAlgorithms();
        Record[] records = null;
        String fileName;
        long startTime, endTime;
        int i, choice;
        double sum = 0, average = 0;
        long[] executionTime = new long[5];

        System.out.println();

        System.out.print("FILE: ");
        fileName = scanner.nextLine();

        System.out.println("[SORTING ALGORITHMS]");
        System.out.println("[1] - Insertion Sort");
        System.out.println("[2] - Selection Sort");
        System.out.println("[3] - Merge Sort");
        System.out.println("[4] - Bubble Sort");
        System.out.print("CHOICE: ");

        try {
            choice = scanner.nextInt();
        } catch (java.util.NoSuchElementException e) {
            choice = -1; 
        }

        System.out.println();

        switch(choice) {
            case 1:
                for(i = 0; i < 5; i++) {
                    records = fileReader.readFile(fileName);
                    startTime = 0;
                    endTime = 0;

                    startTime = System.currentTimeMillis();

                    sortingAlgo.insertionSort(records, records.length);

                    endTime = System.currentTimeMillis();

                    executionTime[i] = endTime - startTime;
                    System.out.println("EXECUTION TIME " + (i+1) + ": " + executionTime[i] + " ms");
                    sortingAlgo.printInsertionSteps();
                }

                for(i = 0; i < 5; i++) {
                    sum += executionTime[i];
                }

                average = sum / 5;

                System.out.println("AVERAGE EXECUTION TIME: " + average + " ms");
                //printRecords(records);
                break;
            case 2:
                for(i = 0; i < 5; i++) {
                    records = fileReader.readFile(fileName);
                    startTime = 0;
                    endTime = 0;

                    startTime = System.currentTimeMillis();

                    sortingAlgo.selectionSort(records, records.length);

                    endTime = System.currentTimeMillis();

                    executionTime[i] = endTime - startTime;
                    System.out.println("EXECUTION TIME " + (i+1) + ": " + executionTime[i] + " ms");
                    sortingAlgo.printSelectionSteps();
                }

                for(i = 0; i < 5; i++) {
                    sum += executionTime[i];
                }

                average = sum / 5;

                System.out.println("AVERAGE EXECUTION TIME: " + average + " ms");
                //printRecords(records);
                break;  
            case 3:
                for(i = 0; i < 5; i++) {
                    records = fileReader.readFile(fileName);
                    startTime = 0;
                    endTime = 0;

                    startTime = System.currentTimeMillis();

                    sortingAlgo.mergeSort(records, 0, records.length - 1);

                    endTime = System.currentTimeMillis();

                    executionTime[i] = endTime - startTime;
                    System.out.println("EXECUTION TIME " + (i+1) + ": " + executionTime[i] + " ms");
                    sortingAlgo.printMergeSteps();
                }

                for(i = 0; i < 5; i++) {
                    sum += executionTime[i];
                }

                average = sum / 5;

                System.out.println("AVERAGE EXECUTION TIME: " + average + " ms");
                //printRecords(records);
                break;
            case 4:
                for(i = 0; i < 5; i++) {
                    records = fileReader.readFile(fileName);
                    startTime = 0;
                    endTime = 0;

                    startTime = System.currentTimeMillis();

                    sortingAlgo.bubbleSort(records, records.length);

                    endTime = System.currentTimeMillis();

                    executionTime[i] = endTime - startTime;
                    System.out.println("EXECUTION TIME " + (i+1) + ": " + executionTime[i] + " ms");
                    sortingAlgo.printBubbleSteps();
                }

                for(i = 0; i < 5; i++) {
                    sum += executionTime[i];
                }

                average = sum / 5;

                System.out.println("AVERAGE EXECUTION TIME: " + average + " ms");
                //printRecords(records);
                break; 
        }



        System.out.println();
        scanner.close();
    }

    /* For ID-Name association checking purposes only.

    private static void printRecords(Record[] records) {
        System.out.println("\nSorted Records:");

        for (Record record : records) {
            System.out.println(record.getIdNumber() + " " + record.getName());
        }
    }

    */
}
