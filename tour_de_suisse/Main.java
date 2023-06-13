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
        int k = In.readInt();
        Graph G = new Graph((m + n) * k + 2);
        for (int i = 0; i < m; ++i) {
          for (int j = 0; j < k; ++j) {
            int s = In.readInt();
            G.addEdge((m + n) * k, i * k + j, s);
          }
        }
        for (int i = 0; i < n; ++i) {
          int d = In.readInt();
          for (int j = 0; j < d; ++j) {
            int v = In.readInt();
            for (int l = 0; l < k; ++l) {
              G.addEdge(v * k + l, (m + i) * k + l, 1);
            }
          }
          for (int j = 0; j < k; ++j) {
            G.addEdge((m + i) * k + j, (m + n) * k + 1, 1);
          }
        }
        
        // Output using Out.java class
        Out.println((G.computeMaximumFlow((m + n) * k, (m + n) * k + 1) == n * k) ? "yes" : "no");
    }
}
