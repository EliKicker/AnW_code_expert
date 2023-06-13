import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test3.in");
        Out.compareTo("public/test3.out");
        
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
        ArrayList<ArrayList<int[]>> G = new ArrayList<>();
        for (int i = 0; i < n; ++i) G.add(new ArrayList<>());
        for (int i = 0; i < n - 1; ++i) {
            int u = In.readInt();
            int v = In.readInt();
            int c = In.readInt();
            G.get(u).add(new int[] {v, c});
        }

        //DP
        int result = 0;
        int[] dp = new int[n];
        int[] queue = new int[n];
        int l = 0, r = 0;
        queue[r++] = 0;

        while (r > l) {
            int u = queue[l++];
            for (int[] x : G.get(u)) {
                queue[r++] = x[0];
                dp[x[0]] = dp[u] + x[1];
                result = Math.max(result, dp[x[0]]);
            }
        }

        // Output using Out.java class
        Out.println(result);
    }
}