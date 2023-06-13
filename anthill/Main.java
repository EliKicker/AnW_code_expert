import algorithms.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test2.in");
        Out.compareTo("public/test2.out");

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
        int s = In.readInt();
        int d = In.readInt();
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        Graph G1 = new Graph(n);
        Graph G2 = new Graph(n);
        Graph G3 = new Graph(n);
        for (int i = 0; i < n; ++i) G.add(new ArrayList<>());
        for (int i = 0; i < s; ++i) {
          int u = In.readInt();
          int v = In.readInt();
          G.get(u).add(v);
          G.get(v).add(u);
          G1.addEdge(u, v, 3000);
          G1.addEdge(v, u, 3000);
          G2.addEdge(u, v, 1);
          G2.addEdge(v, u, 1);
        }
        for (int i = 0; i < d; ++i) {
          int u = In.readInt();
          int v = In.readInt();
          G1.addEdge(u, v, 1);
          G1.addEdge(v, u, 1);
          G3.addEdge(u, v, 1);
          G3.addEdge(v, u, 1);
        }
        
        // Output using Out.java class
        Out.println(G2.computeMaximumFlow(0, n - 1) + " " + (G1.computeMaximumFlow(0, n - 1) - G2.computeMaximumFlow(0, n - 1) * 3000));
    }
}
