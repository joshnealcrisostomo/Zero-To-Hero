package Social_Graph_Networks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    /**
     * 3 Attributes of the ReadFile class
     */
    private int n, e;
    private Graph friendshipGraph;

    /**
     * fileReader method that reads a file from the filename entered by the user, if it exists
     *
     * @param fileName a String that holds the name or directory of the file
     * @return friendshipGraph - an object of the Graph class
     */
    public Graph fileReader(String fileName) {
        int i, person1, person2;

        try {
            Scanner scanner = new Scanner(new File(fileName));
            n = scanner.nextInt(); // Stores the number of accounts in a network
            e = scanner.nextInt(); // Stores the number of friendships in a network

            // Instantiates a graph with (n) number of nodes/elements (accounts)
            friendshipGraph = new Graph(n);

            for(i = 0; i < e; i++) {
                person1 = scanner.nextInt(); // Stores the first person
                person2 = scanner.nextInt(); // Stores the second person

                // Adds an edge (connection) between two persons
                friendshipGraph.addRelationship(person1, person2);
            }

            scanner.close();
        } catch(FileNotFoundException e) {
            // Display a message when the input file name does not exist
            System.out.println("\nFILE DOES NOT EXIST\n");
            return null;
        }

        return friendshipGraph; // Returns the graph
    }
}
