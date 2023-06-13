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
        int r = In.readInt();
        ArrayList<ArrayList<Integer>> G = new ArrayList<>();
        for (int i = 0; i < n; ++i) G.add(new ArrayList<>());
        for (int i = 0; i < m; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            G.get(u).add(v);
            G.get(v).add(u);
        }

        //BFS
        int[] color = new int[n];
        int[] queue = new int[n];
        int d = 0, u = 0;
        queue[u++] = r;
        color[r] = 1;

        while (u > d) {
            int x = queue[d++];

            for (int y : G.get(x)) {
                if (color[y] != color[x] && color[y] != 0) continue;
                if (color[x] == color[y]) {
                    Out.println("no");
                    return;
                }
                queue[u++] = y;
                color[y] = (color[x] == 1) ? 2 : 1;
            }
        }

        String result = "";
        for (int i = 0; i < n; ++i) {
            if (color[i] == 0) {
                Out.println("no");
                return;
            }
            if (color[i] == 1) result += i + " ";
        }

        // Output using Out.java class
        Out.println(result);
    }
}