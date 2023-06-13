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
        int m = In.readInt();
        double[] p = new double[n];
        for (int i = 0; i < n; ++i) {
          p[i] = In.readDouble();
        }
        
        //DP
        double[][] dp = new double[m + 1][n + 1];
        
        //Base Case
        for (int i = 0; i <= m; ++i) dp[i][0] = 1;
        
        //Recursion
        for (int i = 1; i <= m; ++i) {
          for (int j = 1; j <= n; ++j) {
            dp[i][j] = p[j - 1] * dp[i - 1][j - 1] + (1 - p[j - 1]) * dp[i - 1][j]; 
          }
        }
        
        //calc result
        double result = 0;
        for (int i = 1; i <= n; ++i) result += dp[m][i];
        
        // Output using Out.java class
        Out.println(result);
    }
}