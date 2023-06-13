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
        Algorithms.Graph Graph = new Algorithms.Graph(n);
        ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i) G.add(new ArrayList<Integer>());
        for (int i = 0; i < m; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            int c = In.readInt();
            if (c == -1) {
                G.get(u).add(v);
                G.get(v).add(u);
                c = Integer.MAX_VALUE;
            }
            Graph.addEdge(u, v, c);
            Graph.addEdge(v, u, c);
        }

        //check RICH
        boolean[] visited = new boolean[n];
        int[] queue = new int[n];
        int l = 0, r = 0;
        queue[r++] = 0;
        visited[0] = true;
        while (l < r) {
            int u = queue[l++];
            for (int v : G.get(u)) {
                if (visited[v]) continue;
                queue[r++] = v;
                visited[v] = true;
                if (v == n - 1) {
                    Out.println("RICH");
                    return;
                }
            }
        }

        // Output using Out.java class
        Out.println(Graph.computeMaximumFlow(0, n - 1) / 2);
    }
}