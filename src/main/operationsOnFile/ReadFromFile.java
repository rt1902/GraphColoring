package main.operationsOnFile;

import main.graph.Edge;
import main.graph.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromFile {
    public static int[][] readAdjacencyMatrix(String fileName, int vertex) {
        int[][] adjacencyMatrix = new int[vertex][vertex];

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            for (int i = 0; i < vertex; i++){
                for (int j = 0; j < vertex; j++){
                    adjacencyMatrix[i][j] = reader.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with file reader!");
        }

        return adjacencyMatrix;
    }

    public static List<Edge> readListOfEdges(String fileName, Boolean countFrom0) {
        List<Edge> edges = new ArrayList<>();

        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            int numberOfVertices = reader.nextInt();
            while (reader.hasNextLine()){
                edges.add(new Edge(new Node(reader.nextInt()), new Node(reader.nextInt())));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with file reader!");
        }

        return edges;
    }

    public static int readNumberOfVertices(String fileName) {
        int numberOfVertices = 0;
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            numberOfVertices = reader.nextInt();
        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with file reader!");
        }

        return numberOfVertices;
    }
}
