class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test2.in");
        Out.compareTo("public/test2.out");
        Out.setEpsilon(0.000001);

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
        int[][] a = new int[n][k];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < k; ++j) {
                a[i][j] = In.readInt();
            }
        }

        //DP
        double[][] dp = new double[n][k];       //dp[i][j]: probability of winning when then i-th wheel has the j-th value

        //Base Case
        for (int i = 0; i < k; ++i) dp[n - 1][i] = 1;

        //Recursion
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < k; ++j) {
                for (int l = 0; l < k; ++l) {
                    if (a[i + 1][l] >= a[i][j]) dp[i][j] += (1 / (double)k) * dp[i + 1][l];
                }
            }
        }

        //calc result
        double result = 0;
        for (int i = 0; i < k; ++i) result += dp[0][i] * (1 / (double)k);
        
        // Output using Out.java class
        Out.println(result);
    }
}
