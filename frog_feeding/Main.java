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
        int k = In.readInt();
        int m = In.readInt();
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) f[i] = In.readInt();
        double[] p = new double[n];
        for (int i = 0; i < n; ++i) p[i] = In.readDouble();
        
        if (n == 0) {
          Out.println(0);
          return;
        }
        
        //DP
        double[][] dp = new double[m + 1][n];
        for (int i = 0; i < n; ++i) dp[0][i] = f[i];
        for (int i = 1; i <= m; ++i) {
          for (int j = 0; j < n; ++j) {
            if (j == 0) {
              dp[i][j] = f[j] + (1 - p[j]) * dp[i - 1][j + 1];
            } else if (j == n - 1) {
              dp[i][j] = f[j] + p[j] * dp[i - 1][j - 1];
            } else {
              dp[i][j] = f[j] + p[j] * dp[i - 1][j - 1] + (1 - p[j]) * dp[i - 1][j + 1];
            }
          }
        }
        
        // Output using Out.java class
        Out.println(dp[m][k]);
    }
}
