import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");
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
        int g = In.readInt();
        int s = In.readInt();
        double p = In.readDouble();

        //DP
        double[][] dp = new double[g + 1][s + 1];

        //Base Case
        for (int i = 1; i <= g; ++i) dp[i][0] = 1;

        //Recursion
        for (int i = 1; i <= g; ++i) {
            for (int j = 1; j <= s; ++j) {
                double q = ((j / (double)(i + j)) * ((j - 1) / (double)(i + j - 1)) + ((j / (double)(i + j)) * (i / (double)(i + j - 1)) + (i / (double)(i + j)) * (j / (double)(i + j - 1))) * (1 - p));
                dp[i][j] =  q * dp[i][j - 1] + (1 - q) * dp[i - 1][j];
            }
        }

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        Out.println(df.format(dp[g][s]));
    }
}
