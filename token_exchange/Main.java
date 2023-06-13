import algorithms.*;

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
        int m = In.readInt();
        int k = In.readInt();
        int[] e_has = new int[n];
        int[] o_has = new int[m];
        int sum = 0;
        Graph G = new Graph(((n + m) << 1) + 2);
        for (int i = 0; i < n; ++i) {
          int a = In.readInt();
          int b = In.readInt();
          e_has[i] = b;
          G.addEdge((m + n) << 1, i + m + n, e_has[i]);
          G.addEdge(i, 1 + ((m + n) << 1), a);
          sum += a;
        }
        for (int i = 0; i < m; ++i) {
          int c = In.readInt();
          int d = In.readInt();
          o_has[i] = d;
          G.addEdge((m + n) << 1, i + m + (n << 1), o_has[i]);
          G.addEdge(i + n, 1 + ((m + n) << 1), c);
          sum += c;
        }
        for (int i = 0; i < k; ++i) {
          int e = In.readInt();
          int o = In.readInt();
          G.addEdge(e + m + n, o + n, e_has[e]);
          G.addEdge(o + m + (n << 1), e, o_has[o]);
        }
        
        // Output using Out.java class
        Out.println((sum == G.computeMaximumFlow((m + n) << 1, 1 + ((m + n) << 1))) ? "yes" : "no");
    }
}
