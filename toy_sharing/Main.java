import algorithms.*;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");

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
        int[] a = new int[n];
        int[] b = new int[n];
        int sum = 0;
        Graph G = new Graph(2 * n + 2);
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; ++i) {
            a[i] = In.readInt();
            b[i] = In.readInt();
            sum += b[i];
        }
        for (int i = 0; i < m; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            uf.union(u, v);
        }
        for (int i = 0; i < n; ++i) {
            G.addEdge(2 * n, i, a[i]);
            G.addEdge(i + n, 2 * n + 1, b[i]);
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                if (uf.find(i) == uf.find(j)) G.addEdge(i, j + n, 1000000);
            }
        }

        int flow = G.computeMaximumFlow(2 * n, 2 * n + 1);

        // Output using Out.java class
        Out.println((flow == sum) ? "WE MADE IT!" : sum - flow);
    }

    private static class UnionFind {
        int[] r, s;
        UnionFind(int n) {
            r = new int[n];
            s = new int[n];
            for (int i = 0; i < n; ++i) {
                r[i] = i;
                s[i] = 1;
            }
        }
        int find(int x) {
            if (x == r[x]) return x;
            return r[x] = find(r[x]);
        }
        void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (s[a] > s[b]) {
                r[b] = a;
                s[a] += s[b];
            } else {
                r[a] = b;
                s[b] += s[a];
            }
        }
    }
}
