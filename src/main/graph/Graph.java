package main.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

// A class to represent a graph object
public class Graph {

    private Map<Node, List<Node>> adjList;
    private List<Edge> edges;
    private int numberOfVertices;

    public Graph(List<Edge> edges, int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.edges = edges;
        this.adjList = mapListOfEdgesToAdjList(edges, numberOfVertices);
    }

    public Graph(int [][] adjacencyMatrix) {
        this(mapAdjacencyMatrixToListOfEdges(adjacencyMatrix), adjacencyMatrix.length);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public Map<Node, List<Node>> getAdjList() {
        return adjList;
    }

    static public int[][] genRandomAdjacencyMatrix(int numberOfVertices, int saturation) {
        int[][] result = new int[numberOfVertices][numberOfVertices];
        Random rand = new Random();

        //clear graph
        Arrays.fill(result, 0);

        //generate adjacency matrix with given number of vertices and saturation
        for (int i = 1; i < numberOfVertices; i++)
            for (int j = 0; j < i; j++)
                if (rand.nextInt(100) < saturation) {
                    result[i][j] = 1;
                    result[j][i] = 1;
                }
        return result;
    }

    static public List<Edge> mapAdjacencyMatrixToListOfEdges(int [][] adjacencyMatrix) {
        List<Edge> result = new ArrayList<>();
        int numberOfVertices = adjacencyMatrix.length;

        for (int i = 1; i < numberOfVertices; i++) {
            for (int j = 0; j < i; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    result.add(new Edge(new Node(i), new Node(j)));
                }
            }
        }
        return result;
    }

    static public List<Edge> mapArrayOfEdgesToListOfEdges(int [][] arrayOfEdges) {
        List<Edge> result = new ArrayList<>();
        int numberOfEdges = arrayOfEdges.length;

        for (int i = 1; i < numberOfEdges; i++) {
            result.add(new Edge(new Node(arrayOfEdges[i][0]), new Node(arrayOfEdges[i][1])));
        }
        return result;
    }

    static public Map<Node, List<Node>>  mapListOfEdgesToAdjList(List<Edge> edges, int numberOfVertices) {
        Map<Node, List<Node>>  adjList = new HashMap<>();

        for (int i = 1; i <= numberOfVertices; i++) {
            adjList.put(new Node(i), new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            Node src = edge.source;
            Node dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        return adjList;
    }

    static public Boolean isConsistent(Map<Node, List<Node>> adjList) {
        List<Node> visited = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push((Node) adjList.get(adjList.keySet().stream().findFirst()));
        while (!stack.isEmpty()) {
            Node vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Node node : adjList.get(vertex)) {
                    stack.push(node);
                }
            }
        }
        return visited.size() == adjList.size();
    }

    static public void printGraph(Map<Node, List<Node>> adj) {
        for (Node node : adj.keySet()) {
            System.out.print(node.getLabel());
            for (int j = 0; j < adj.get(node).size(); j++) {
                System.out.print(" -> " + adj.get(node).get(j).getLabel());
            }
            System.out.println();
        }
    }

    public void printGraph() {
        printGraph(this.adjList);
    }

    public Boolean isConsistent() {
        return isConsistent(this.adjList);
    }
}
