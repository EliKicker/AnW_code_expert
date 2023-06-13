import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test3.in");
        Out.compareTo("public/test3.out");
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
        int m = In.readInt();
        double[] p = new double[n];
        for (int i = 0; i < n; ++i) p[i] = In.readDouble();

        //DP
        double[] dp = new double[n + 1];

        //Base Case
        dp[0] = 1;

        //Recursion
        for (int i = 1; i <= n; ++i) dp[i] = p[i - 1] * (1 - dp[i - 1]) + (1 - p[i - 1]) * dp[i - 1];
        
        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.DOWN);
        Out.println(df.format(dp[n]));
    }
}