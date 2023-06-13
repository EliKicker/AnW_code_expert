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
        int k = In.readInt();
        double[] p = new double[n];
        for (int i = 0; i < n; ++i) p[i] = In.readDouble();
        
        //DP
        double[][] dp = new double[n + 1][k + 1];
        
        //base case
        for (int i = 0; i <= n; ++i) dp[i][0] = 1.0;
        
        //recursion
        for (int i = 1; i <= n; ++i) {
          for (int j = 1; j <= k; ++j) {
            dp[i][j] = (1 - p[i - 1]) * dp[i - 1][j] + p[i - 1] * dp[i - 1][j - 1];
          }
        }
        
        // Output using Out.java class
        Out.println(dp[n][k]);
    }
}
