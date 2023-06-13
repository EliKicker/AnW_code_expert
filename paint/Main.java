import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");
        //Out.setEpsilon(0.0001);

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
        int w = In.readInt();
        int x = In.readInt();
        double result = 0;

        if (x == 1) {
            double p_black = (w / (double)(b + w)) * ((b + 1) / (double)(b + w)) + (b / (double)(b + w)) * (b / (double)(b + w));
            result = p_black;
        } else if (x == 2) {
            double p_black = (w / (double)(b + w)) * ((b + 1) / (double)(b + w)) + (b / (double)(b + w)) * (b / (double)(b + w));
            double p_black_and_repainted = (w / (double)(b + w)) * ((b + 1) / (double)(b + w));
            result = p_black_and_repainted / p_black;
        } else if (x == 3) {

            //DP
            double[][] dp = new double[w + 2][w + 1];

            //Base Case
            for (int i = 0; i <= w + 1; ++i) dp[i][0] = 1;

            //Recursion
            for (int i = 1; i <= w + 1; ++i) {
                for (int j = 1; j <= w; ++j) {
                    dp[i][j] = ((w - j + 1) / (double)(b + w)) * dp[i - 1][j - 1] + (1 - (w - j + 1) / (double)(b + w)) * dp[i - 1][j];
                }
            }

            result = dp[w + 1][w];
        }

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("#.########");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        Out.println(df.format(result));
    }
}
