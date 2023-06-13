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
        int q = In.readInt();
        double[] p = new double[6];
        for (int i = 0; i < 6; ++i) p[i] = In.readDouble();
        double result = 0;
        
        if (q == 1) {
          result = (p[1] + p[3] + p[5]) / 6;
        } else if (q == 2) {
          double pr_7_2_and_3_1 = p[2] * p[3];
          double pr_7_2 = (p[0] * p[5] + p[1] * p[4] + p[2] * p[3]) * 2;
          result = pr_7_2_and_3_1 / pr_7_2;
        } else if (q == 3) {
          double[] dp = new double[n + 1];
          for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < 6; ++j) {
              dp[i] += p[j] * (1 + dp[Math.min(i + j + 1, n)]);
            }
          }
          result = dp[0];
        }
        
        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("#.#######");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        Out.println(df.format(result));
    }
}
