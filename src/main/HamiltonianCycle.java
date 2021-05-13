package main;

import java.util.ArrayList;
import java.util.List;

class Edge
{
    int source, dest;

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

class HamiltonianCycle {
    public static void findAllHamiltonianCycle(int[][] graph) {
        List<Edge> edges = new ArrayList<>();
        int n = graph.length;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (graph[i][j] == 1) {
                    edges.add(new Edge(i, j));
                }
        Graph g = new Graph(edges, n);
        // starting node
        int start = 0;

        // add starting node to the path
        List<Integer> path = new ArrayList<>();
        path.add(start);

        // mark the start node as visited
        boolean[] visited = new boolean[n];
        visited[start] = true;
        findAllHamiltonianCycle(g, start, visited, path, n);
    }

    public static void findAllHamiltonianCycle(Graph g, int v, boolean[] visited, List<Integer> path, int N) {
        // if all the vertices are visited, then the Hamiltonian path exists
        if (path.size() == N) {
            // print the Hamiltonian path
            /*System.out.println(path);*/
            return;
        }

        // Check if every edge starting from vertex `v` leads
        // to a solution or not
        for (int w : g.adjList.get(v)) {
            // process only unvisited vertices as the Hamiltonian
            // path visit each vertex exactly once
            if (!visited[w]) {
                visited[w] = true;
                path.add(w);

                // check if adding vertex `w` to the path leads
                // to the solution or not
                findAllHamiltonianCycle(g, w, visited, path, N);

                // backtrack
                visited[w] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}