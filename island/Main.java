import algorithms.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");
        Out.setEpsilon(0.00001);

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int b = In.readInt();
        int h = In.readInt();
        int n = In.readInt();

        //DP
        int max = Math.max(b, Math.max(h, n));
        double[][][] dp = new double[max + 1][max + 1][max + 1];

        //Base Case
        for (int i = 1; i <= max; ++i) {
            for (int j = 0; j <= max; ++j) {
                dp[i][0][j] = 1;
            }
        }

        //Recursion
        for (int i = 1; i <= max; ++i) {
            for (int j = 1; j <= max; ++j) {
                for (int k = 0; k <= max; ++k) {
                    double combis = Algorithms.binom(i + j + k, 2) - Algorithms.binom(i, 2) - Algorithms.binom(j, 2) - Algorithms.binom(k, 2);
                    if (k != 0) dp[i][j][k] = ((i * j) / combis) * dp[i - 1][j][k] + ((i * k) / combis) * dp[i][j][k - 1] + ((j * k) / combis) * dp[i][j - 1][k];
                }
            }
        }

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("0.0#####");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        Out.println(df.format(dp[b][h][n]) + " " + df.format(dp[h][n][b]) + " " + df.format(dp[n][b][h]));
    }
}
