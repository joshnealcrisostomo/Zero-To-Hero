package Social_Graph_Networks;

import java.util.*;

public class Graph {
    /**
     * 1 Attribute of the Graph Class
     */
    private ArrayList<ArrayList<Integer>> graph;

    /**
     * The sole constructor of the Graph class
     *
     * @param numNodes an int that holds the number of nodes
     */
    public Graph(int numNodes){
        int i;
        graph =  new ArrayList<>();

        for (i = 0; i < numNodes; i++){
            graph.add(new ArrayList<>()); // Creates new ArrayLists for each node/element
        }
    }

    /**
     * addRelationship method that adds a bidirectional relationship between the nodes.
     *
     * @param v an int that represents the 1st person (p1)
     * @param u an int that represents the 2nd person (p2)
     */
    public void addRelationship(int v, int u){
        // Bidirectional, meaning p1 is friends with p2 and p2 is also friends with p1

        // Add u to v's list if it's not already present
        if (!graph.get(v).contains(u)) {
            graph.get(v).add(u); // Gets the index of p1 and adds the p2 to p1's ArrayList
        }

        // Add v to u's list if it's not already present
        if (!graph.get(u).contains(v)) {
            graph.get(u).add(v); // Gets the index of p2 and adds the p1 to p2's ArrayList
        }
    }

    /**
     * displayFriends method that displays a persons ID number and its list of friends
     *
     * @param idNumber an int that holds the ID number of the person
     */
    public void displayFriends(int idNumber) {
        // Checks if the idNumber exists or not
        if(idNumber >= 0 && idNumber < graph.size()) {
            System.out.println("Person " + idNumber + " has " + graph.get(idNumber).size() + " friends!");
            System.out.print("List of friends: ");

            //  Uses for-each loop to iterate through each of the idNumber's friends (nodes inside idNumber's ArrayList)
            for(int x : graph.get(idNumber)){
                System.out.print(x + " "); // Prints idNumber's friends
            }
            System.out.println();

        } else {
            System.out.println("ID NUMBER DOES NOT EXIST"); // if the given ID Number is not in the text file.
        }
    }

    /**
     * findConnections method that initializes the needed attributes for DFS and calls DFS to check if it found a path.
     *
     * @param start the starting node or person a
     * @param end the ending node oer person b
     * @return a list representing the path from start to end, or null if no path exists
     */
    public List<Integer> findConnections(int start, int end) {
        Stack<Integer> path = new Stack<>(); // Instantiate a new Stack
        boolean[] nodeVisited = new boolean[graph.size()]; // Boolean array with graph.size() size

        // Checks if there is a path from start to end using DFS
        if (depthFirstPath(start, end, path, nodeVisited)) {
            return new ArrayList<>(path); // If a path is found, return the new ArrayList from the path
        } else {
            return null; // Return null, if no path found
        }
    }

    /**
     * depthFirstPath method that finds the connection of person 1 to person 2 using depth first search.
     *
     * @param start an integer value that holds the ID number of person 1
     * @param end an integer value that holds the ID number of person 2
     * @param socialPath a stack that holds the path of the connection
     * @param nodeVisited a boolean array that holds the values of each node, which is true or false
     * @return true or false, depending on the conditions
     */
    private boolean depthFirstPath(int start, int end, Stack<Integer> socialPath, boolean[] nodeVisited) {
        socialPath.push(start); // Push (add) person 1 as the start of the connection
        nodeVisited[start] = true; // Initialize as true

        // Checks if person 1 is the same person as person 2
        if (start == end) {
            return true; // Return true if person 1 is person 2
        }

        // Iterates through each node (friend) of person 1's ArrayList
        for (int personNode : graph.get(start)) {
            // Checks if the node is visited or not
            if (!nodeVisited[personNode]) {
                // If it is not yet visited, continue DFS
                if (depthFirstPath(personNode, end, socialPath, nodeVisited)) {
                    return true; // If a path is found from the adjacent node to the end node, return true
                }
            }
        }

        socialPath.pop(); // Pop (remove) the current node (friend) from the path if there's no path found from this node
        return false; // If no path is found from the adjacent node to the end node, return false
    }
}