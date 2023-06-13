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
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for (int i = 0; i < n; ++i) G.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int a = In.readInt();
            int b = In.readInt();
            G.get(a).add(b);
            G.get(b).add(a);
        }

        //artikulationsknoten
        boolean[] roots = new boolean[n];
        int[] prev = new int[n];
        int[] dfs = new int[n];
        int[] low = new int[n];
        int[] stack = new int[m << 1];
        int p = 0, t = 1;

        for (int i = 0; i < n; ++i) {
            if (dfs[i] != 0) continue;
            roots[i] = true;
            prev[i] = -1;
            stack[p++] = i;
            while (p > 0) {
                int u = stack[--p];
                if (dfs[u] == 0) low[u] = dfs[u] = t++;
                else continue;
                for (int v : G.get(u)) {
                    if (dfs[v] != 0) {
                        if (dfs[v] > dfs[u] || prev[u] == v) continue;
                        low[u] = Math.min(low[u], dfs[v]);
                        for (int x = u; x != v; x = prev[x]) low[prev[x]] = Math.min(low[prev[x]], low[x]);
                        continue;
                    }
                    stack[p++] = v;
                    prev[v] = u;
                }
            }
        }

        String result = "";
        for (int i = 0; i < n; ++i) {
            if (!roots[i]) {
                for (int j : G.get(i)) {
                    if (low[j] >= dfs[i]) {
                        result += i + " ";
                        break;
                    }
                }
            } else {
                int c = 0;
                for (int j = 0; j < n; ++j) if (prev[j] == i) c++;
                if (c > 1) result += i + " ";
            }
        }

        if (!result.isEmpty()) {
            Out.println(result);
            return;
        }
        
        // Output using Out.java class
        Out.println("-1");
    }
}