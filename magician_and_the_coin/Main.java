import algorithms.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
      int k = In.readInt();
      int m = In.readInt();
      double[] p = new double[n];
      for (int i = 0; i < n; ++i) p[i] = In.readDouble();
      
      //DP
      double[][] dp = new double[n + 1][m + 1];
      
      //Base Case
      dp[0][m] = 1;
      
      //Recursion
      for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
          for (int l = 0; l <= j; ++l) {
            dp[i][j] = Math.max(dp[i][j], p[n - i] * dp[i - 1][Math.min(m, j + l)] + (1 - p[n - i]) * dp[i - 1][Math.max(0, j - l)]);
          }
        }
      }
      
      // Output using Out.java class
      DecimalFormat df = new DecimalFormat("0.0###");
      df.setRoundingMode(RoundingMode.DOWN);
      Out.println(df.format(dp[n][k]));
    }
}
