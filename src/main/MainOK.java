package main;

import main.graph.Edge;
import main.graph.Graph;
import main.operationsOnFile.ReadFromFile;

import java.util.List;

public class MainOK {
    public static void main(String[] args) {
        List<Edge> listOfEdges = ReadFromFile.readListOfEdges("input2.txt", Boolean.TRUE);
        int numberOfVertices = ReadFromFile.readNumberOfVertices("input2.txt");
        Graph graph = new Graph(listOfEdges, numberOfVertices);
        graph.printGraph();
    }
}
