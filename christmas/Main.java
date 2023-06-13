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
        int m = In.readInt();
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for (int i = 0; i < n; ++i) G.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            G.get(u).add(v);
            G.get(v).add(u);
        }

        //check odd cycle
        int[] pre = new int[n];
        int[] prev = new int[n];
        int[] stack = new int[m];
        int p = 0, t = 1;

        for (int i = 0; i < n; ++i) {
            if (pre[i] != 0) continue;
            stack[p++] = i;
            while (p > 0) {
                int u = stack[--p];
                if (pre[u] == 0) pre[u] = t++;
                else continue;
                for (int v : G.get(u)) {
                    if (pre[v] != 0) {
                        if (pre[v] > pre[u]) continue;
                        int len = 1;
                        for (int x = u; x != v; x = prev[x]) len++;
                        if ((len & 1) == 1) {
                            Out.println("no");
                            return;
                        }
                    } else {
                        stack[p++] = v;
                        prev[v] = u;
                    }
                }
            }
        }
        
        // Output using Out.java class
        Out.println("yes");
    }
}
