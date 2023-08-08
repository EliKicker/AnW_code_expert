import algorithms.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");
        Out.setEpsilon(0.0001);

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
        int q = In.readInt();
        double[] p = new double[n];
        int[] f = new int[n];
        for (int i = 0; i < n; ++i) p[i] = In.readDouble();
        for (int i = 0; i < n; ++i) f[i] = In.readInt();

        //---
        DecimalFormat df = new DecimalFormat("0.0######");
        df.setRoundingMode(RoundingMode.HALF_UP);
        //---

        if (q == 1) {
          int f_x = In.readInt();
          int x = In.readInt();
          int sum_x = 0;
          for (int i = 0; i < n; ++i) {
            if (f[i] == f_x) ++sum_x;
          }
          Out.println(df.format(1 / (double)sum_x));
          return;
        } else if (q == 2) {
          int x = In.readInt();
          int y = In.readInt();
          int m = In.readInt();
          
          //dp
          double[][] dp = new double[n][m + 1]; //dp[i][j]: prob of landing on i after j jumps
          
          //base case
          dp[x][0] = 1;
          
          //rec
          for (int j = 1; j <= m; ++j) {
            for (int i = 0; i < n; ++i) {
              if (i > 0) {
                dp[i][j] += dp[i - 1][j - 1] * (1 - p[0]);
              }
              if (i < n - 1) {
                dp[i][j] += dp[i + 1][j - 1] * p[0];
              }
            }
          }
          
          Out.println(df.format(dp[y][m]));
          return;
        } else if (q == 3) {
          int x = In.readInt();
          int m = In.readInt();
          
          //dp
          double[][] dp = new double[n][m + 1]; //dp[i][j]: expected number of flies to eat on pos i with j jumps left
          
          //base case
          for (int i = 0; i < n; ++i) dp[i][0] = f[i];
          
          //rec
          for (int j = 1; j <= m; ++j) {
            for (int i = 0; i < n; ++i) {
              dp[i][j] = f[i];
              if (i > 0) {
                dp[i][j] += dp[i - 1][j - 1] * p[i];
              }
              if (i < n - 1) {
                dp[i][j] += dp[i + 1][j - 1] * (1 - p[i]);
              }
            }
          }
          
          Out.println(df.format(dp[x][m]));
          return;
        }
        
        // Output using Out.java class
        Out.println(n + n);
    }
}
