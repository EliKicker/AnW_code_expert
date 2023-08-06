import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("vanishing_bag/public/sample.in");
        Out.compareTo("vanishing_bag/public/sample.out");
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
        int w = In.readInt();
        int b = In.readInt();

        //DP
        double[][][] dp = new double[w + 1][b + 1][2]; //dp[i][j][k]: probability of me winning game if i white and j black stoned are on the board and either 1 (me) or 0 (other) is on the move

        //Base Case
        for (int i = 1; i <= w; ++i) {
            dp[i][0][0] = 0;
            dp[i][0][1] = 1;
        }
        for (int j = 0; j <= b; ++j) {
            dp[0][j][0] = 1;
            dp[0][j][1] = 1;
        }

        //Rec
        for (int i = 1; i <= w; ++i) {
            for (int j = 1; j <= b; ++j) {
                double p_b = j / (double)(j + i);                                                               //pr current player draws black stone
                double p_b_e = ((j - 1) / (double)(j + i - 1));                                                 //pr black stone gets evicted given a black stone got drawn

                if (j >= 2) {
                    dp[i][j][0] = p_b * (dp[i - 1][j - 1][1] * (1 - p_b_e) + dp[i][j - 2][1] * p_b_e) + (1 - p_b) * 0;
                    dp[i][j][1] = p_b * (dp[i - 1][j - 1][0] * (1 - p_b_e) + dp[i][j - 2][0] * p_b_e) + (1 - p_b) * 1;
                } else {
                    dp[i][j][0] = p_b * dp[i - 1][j - 1][1] + (1 - p_b) * 0;
                    dp[i][j][1] = p_b * dp[i - 1][j - 1][0] + (1 - p_b) * 1;
                }
            }
        }

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("0.0####");
        df.setRoundingMode(RoundingMode.HALF_UP);
        Out.println(df.format(dp[w][b][0]));
    }
}