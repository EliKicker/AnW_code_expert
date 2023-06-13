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
        int[] p = new int[n];
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = In.readInt();
            f[i] = In.readInt();
        }

        //compute result
        int sum = 0;
        Graph G = new Graph(2 * n + 2);
        for (int i = 0; i < m; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            G.addEdge(u + n, v, p[u]);
        }
        for (int i = 0; i < n; ++i) {
            G.addEdge(i, i + n, p[i]);
            if (p[i] > f[i]) G.addEdge(2 * n, i, p[i] - f[i]);
            else {
                sum += f[i] - p[i];
                G.addEdge(i, 2 * n + 1, f[i] - p[i]);
            }
        }

        if (sum == G.computeMaximumFlow(2 * n, 2 * n + 1)) {
            Out.println("yes");
        } else {
            Out.println("no");
        }
    }
}
 