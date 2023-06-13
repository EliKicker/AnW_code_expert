import java.util.Arrays;

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
        int[] d = new int[n];
        int[] c = new int[m];
        for (int i = 0; i < n; ++i) d[i] = In.readInt();
        for (int i = 0; i < m; ++i) c[i] = In.readInt();

        //calc sol
        int sum = 0;
        Algorithms.Graph G = new Algorithms.Graph(m + n + 2);
        for (int i = 0; i < m; ++i) {
            G.addEdge(m + n, i, c[i]);
            for (int j = m; j < m + n; ++j) {
                G.addEdge(i, j, 1);
                if (i != 0) continue;
                sum += d[j - m];
                G.addEdge(j, m + n + 1, d[j - m]);
            }
        }

        if (sum == G.computeMaximumFlow(n + m, n + m + 1)) {
            Out.println("yes");
            return;
        }

        // Output using Out.java class
        Out.println("no");
    }
}