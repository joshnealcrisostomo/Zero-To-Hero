package Social_Graph_Networks;

import java.util.*;

public class Main {
    private static Graph socialGraph;
    private static ReadFile readFile = new ReadFile();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String fileName;
        int menuChoice;
        boolean menuLoop = true;

        // Loops until the user entered an existing and valid file name.
        do {
            System.out.print("Input file path: ");
            fileName = scanner.nextLine();

            // Stores the read graph from a file to a graph variable.
            socialGraph = readFile.fileReader(fileName);
        } while(socialGraph == null);

        // Loops until the user entered a valid integer
        while(menuLoop) {
            System.out.println();
            System.out.println("MAIN MENU");
            System.out.println("[1] Get friend list");
            System.out.println("[2] Get connection");
            System.out.println("[3] Exit");
            System.out.println();

            System.out.print("Choice: ");
            menuChoice = scanner.nextInt(); // Stores the choice of the user.
            scanner.nextLine();

            switch(menuChoice) {
                case 1:
                    displayFriendList();
                    break;
                case 2:
                    displayConnections();
                    break;
                case 3:
                    menuLoop = false;
                    break;
                default:
                    System.out.println("\nEnter 1-3 only."); // Display a message for invalid integer inputs
                    break;
            }
        }

        scanner.close();
    }

    private static void displayFriendList() {
        int id;

        System.out.println();
        System.out.print("Enter an ID number: "); // Asks the user to enter an ID number.
        id = scanner.nextInt();

        // Passes the input ID number to the method displayFriends in the Graph class.
        socialGraph.displayFriends(id);
    }

    private static void displayConnections() {
        List<Integer> path;
        int i, p1, p2;

        System.out.print("Enter ID of first person: ");
        p1 = scanner.nextInt(); // Stores the ID number of person 1

        System.out.print("Enter ID of second person: ");
        p2 = scanner.nextInt(); // Stores the ID number of person 2

        path = socialGraph.findConnections(p1, p2); // Stores the path (connections) returned by findConnections

        // Checks if there is a path (connection) found
        if (path == null) {
            // Displays an error message, if there are no connections
            System.out.println("\nCannot find a connection between " + p1 + " and " + p2);
        } else {
            // Displays the connection from person 1 to person 2
            System.out.println("\nThere is a connection between " + p1 + " and " + p2 + "!");

            // Iterates through each of the path's node (person) until it reaches the end
            for (i = 0; i < path.size() - 1; i++) {
                System.out.println(path.get(i) + " is friends with " + path.get(i + 1));
            }
        }
    }
}
