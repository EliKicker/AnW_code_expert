import java.util.ArrayList;
import java.util.LinkedList;

public class Algorithms {
    /**
    * Computes the binomial coefficient `n` choose `k`, that is:
    * n! / ((n-k)! k!).
    * 
    * Note: This value gets large very quickly and 
    * might not fit into long even for relatively small `n` and `k`.
    * 
    * @return   n choose k
    */
    public static long binom(int n, int k) {
        if (k > n || n < 0 || k < 0) return 0;
        long[][] bin = new long[n + 1][k + 1];
        return rec_binom(n, k, bin);
    }

    /**
    * Helper function that computes the binomial coefficient `n` choose `k`
    * recursively, using the array bin for memoization.
    * 
    * @return    n choose k
    */
    private static long rec_binom(int n, int k, long[][] bin) {
        if (k == 0 || k == n) {
            bin[n][k] = 1;
            return 1;
        }

        if (bin[n][k] != 0) {
            return bin[n][k];
        }

        bin[n][k] = rec_binom(n - 1, k - 1, bin) + rec_binom(n - 1, k, bin);

        return bin[n][k];
    }

    /**
    * Computes `n` factorial (n!).
    * 
    * Note: This value gets large very quickly and
    * might not fit into long even for relatively small `n`.
    * 
    * @param     n   the number, the factorial of which is to be
    *                computed
    * 
    * @return    n!
    */
    public static long fact(int n) {
        if (n <= 0) return 1;
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    /**
    * This class represents a graph with implementation of an algorithm
    * that finds the maximum flow. Since it is a nested class in another
    * class, you can access it via Algorithms.Graph.
    * You can create a new instance of this class with the following command:
    * 
    * Algorithms.Graph g = new Algorithms.Graph(numVertices);
    * 
    * This will create a new graph `g` with `numVertices` vertices. 
    * You can then access any public member of this instance in the usual way:
    * 
    * g.addEdge(0, 1, 5); 
    * 
    * This will add an edge from vertex 0 to vertex 1 with capacity 5.
    * 
    * int maxFlow = g.computeMaximumFlow(0, 1);
    * 
    * This will compute the maximum flow from vertex 0 (source)
    * to vertex 1 (sink).
    */
    public static class Graph {
        public int numVer;  // number of vertices in the graph
        public ArrayList<Integer> graph[];  // adjacency list of the graph
        public int[][] capacity;  // capacities of the edges
        public int[][] flow;  // flows currently passing through the edges
        public boolean flow_computed = false; // a flag indicating whether the flow is computed

        /**
         * Creates a new instance of a graph with `n` vertices.
         */
        public Graph(int n) {
            numVer = n;
            
            capacity = new int[numVer][numVer];
            flow = new int[numVer][numVer];
            
            graph = (ArrayList<Integer>[])new ArrayList[numVer];
            for (int i = 0; i < numVer; i++)
                graph[i] = new ArrayList<Integer>();
        }

        /**
         * Adds an edge from `u` to `v` with capacity `c` to the graph.
         * If an edge from `u` to `v` already exists, it adds `c` to its capacity.
         */
        public void addEdge(int u, int v, int c) {
            if (c == 0) return;
            if (capacity[u][v] == 0 || capacity[v][u] == 0) {
                graph[u].add(v);
                graph[v].add(u);
            }
            
            capacity[u][v] += c;
        }

        /**
         * Computes the value of a maximum flow from `source` to `sink` in
         * the graph.
         * 
         * @return  the value of the maximum flow from `source` to `sink`
         */
        public int computeMaximumFlow(int source, int sink) {
            if (flow_computed) {
                System.err.println("You can only call computeMaximumFlow() once per graph.");
                System.err.println("Generate a new graph if you want to compute a different flow.");
                return -1;
            }
            flow_computed = true;
            int i, flowOnPath;
            // Find paths with BFS and return path in `previousVertexOnPath` array
            int[] previousVertexOnPath = new int[numVer];
            // Start with empty flow
            int maxFlow = 0;
            // Use augmenting path `P` as long as possible
            while (augmentingPathExists(previousVertexOnPath, source, sink)) {
                // Compute smallest remaining capacity on `P`
                flowOnPath = Integer.MAX_VALUE;
                for (i = sink; i != source; i = previousVertexOnPath[i]) {
                    int p = previousVertexOnPath[i];
                    flowOnPath = Math.min(flowOnPath, capacity[p][i] - flow[p][i]);
                }
                // Add the smallest remaining capacity to each edge of `P`
                for (i = sink; i != source; i = previousVertexOnPath[i]) {
                    int p = previousVertexOnPath[i];
                    flow[p][i] += flowOnPath;
                    flow[i][p] -= flowOnPath;
                }
                maxFlow += flowOnPath; 
            }

            return maxFlow;
        }

        /** 
         * Helper function that computes a path with positive residual
         * capacity using BFS.
         * 
         * @return  true if such a path exists and false otherwise.
         */
        private boolean augmentingPathExists(int previousVertexOnPath[], int source, int sink) {
            // Allocate space for auxiliary data structures
            LinkedList<Integer> queue = new LinkedList<Integer>();
            boolean[] visited = new boolean[numVer];
            
            // Initialization of auxiliary data structures
            for (int i = 0; i < numVer; i++) visited[i] = false;
            queue.add(source);
            visited[source] = true;
            
            // BFS
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w : graph[v])
                    if (!visited[w] && capacity[v][w] > flow[v][w]) {
                        visited[w] = true;
                        previousVertexOnPath[w] = v;
                        queue.add(w);
                        if (w == sink) return true;
                    }
            }
            
            return false;
        }
    }
}
