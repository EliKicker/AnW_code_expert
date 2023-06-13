import algorithms.*;
import java.util.ArrayList;

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
        int v = In.readInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
          int u = In.readInt();
          int w = In.readInt();
          graph.get(u).add(w);
          graph.get(w).add(u);
        }
        
        int[] d = new int[n];
        for (int i = 0; i < n; ++i) d[i] = -1;
        int[] queue = new int[n];
        int l = 0, r = 0;
        queue[r++] = v;
        d[v] = 0;
        
        while (l < r) {
          int u = queue[l++];
          
          for (int w : graph.get(u)) {
            if (d[w] != -1) continue;
            queue[r++] = w;
            d[w] = d[u] + 1;
          }
        }
        
        // Output using Out.java class
        String s = "";
        for (int i = 0; i < n; ++i) s += d[i] + " ";
        Out.println(s);
    }
}
