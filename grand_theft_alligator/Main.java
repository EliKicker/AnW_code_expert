import algorithms.*;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/custom.in");
        Out.compareTo("public/custom.out");

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
        int r = In.readInt();
        int a = In.readInt();
        int b = In.readInt();
        int c = In.readInt();
        Graph G = new Graph(n);
        for (int i = 0; i < m; ++i) {
          int u = In.readInt();
          int v = In.readInt();
          int k = In.readInt();
          G.addEdge(u, v, k);
        }
        for (int i = 0; i < r; ++i) {
          int u = In.readInt();
          int v = In.readInt();
          G.addEdge(u, v, m * 100);
        }
        
        int res = Math.min(G.computeMaximumFlow(a, b), G.computeMaximumFlow(b, c));
        
        // Output using Out.java class
        Out.println((res >= m * 100) ? "RICH" : res);
    }
}
