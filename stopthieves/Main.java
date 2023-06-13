import algorithms.*;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        int m = In.readInt();
        Graph G = new Graph(n);
        ArrayList<ArrayList<Integer>> neg_roads = new ArrayList<>();
        for (int i = 0; i < n; ++i) neg_roads.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            int w = In.readInt();
            if (w < 0) {
                neg_roads.get(u).add(v);
                G.addEdge(u, v, Integer.MAX_VALUE);
            } else G.addEdge(u, v, w);
        }

        //check possibility
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int l = 0, r = 0;
        queue[r++] = 0;
        visited[0] = true;

        while (r > l) {
            int u = queue[l++];

            for (int v : neg_roads.get(u)) {
                if (visited[v]) continue;
                queue[r++] = v;
                visited[v] = true;
                if (v == n - 1) {
                    Out.println("no");
                    return;
                }
            }
        }

        // Output using Out.java class
        Out.println(G.computeMaximumFlow(0, n - 1));
    }
}
