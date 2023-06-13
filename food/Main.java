import algorithms.*;

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
        Graph G = new Graph(m + n + 2);

        for (int i = 0; i < n; ++i) G.addEdge(m + n, i, In.readInt());
        for (int i = 0; i < m; ++i) {
            int k = In.readInt();
            for (int j = 0; j < k; ++j) G.addEdge(In.readInt(), n + i, 1);
            G.addEdge(n + i, m + n + 1, 1);
        }
        
        // Output using Out.java class
        Out.println((G.computeMaximumFlow(m + n, m + n + 1) == m) ? "yes" : "no");
    }
}
