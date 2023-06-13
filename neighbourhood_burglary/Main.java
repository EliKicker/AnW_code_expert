import algorithms.*;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/custom.in");
        Out.compareTo("public/custom.out");

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
        int[] v = new int[n];
        double[] e = new double[n];
        double[] o = new double[n];
        for (int i = 0; i < n; ++i) v[i] = In.readInt();
        for (int i = 0; i < n; ++i) {
          e[i] = In.readDouble();
          o[i] = In.readDouble();
        }
        
        //questions
        if (q == 1) {
          
          //calc E[X]
          double result = v[0];
          for (int i = 1; i < n; ++i) {
            result += e[i] * v[i];
          }
          Out.println(result);
          return;
        } else if (q == 2) {
          
          //check if 0
          if (v[0] > v[2] || v[1] > v[2] || v[0] > v[1]) {
            Out.println(0);
            return;
          }
          double pr_3 = 1;
          double pr_2_3 = 1;
          
          //calc probabilities
          if (((v[1] - v[0]) & 1) == 0) pr_3 = e[1];
          else pr_3 = o[1];
          if (((v[2] - v[1]) & 1) == 0) pr_2_3 = pr_3 * e[2];
          else pr_2_3 = pr_3 * o[2];
          if (((v[2] - v[0]) & 1) == 0) pr_3 = pr_2_3 + (1 - pr_3) * e[2];
          else pr_3 = pr_2_3 + (1 - pr_3) * o[2];
          
          Out.println(pr_2_3 / pr_3);
          return;
        } else if (q == 3) {
          
          //calc probabilities and E[X]
          double result = v[0];
          double[] dp = new double[n];
          dp[0] = 1;
          for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
              double prod = dp[j];
              for (int k = j + 1; k < i; ++k) {
                if (v[j] > v[k]) continue;
                if (((v[k] - v[j]) & 1) == 0) prod *= 1 - e[k];
                else prod *= 1 - o[k];
              }
              if (v[j] > v[i]) continue;
              if (((v[i] - v[j]) & 1) == 0) dp[i] += prod * e[i];
              else dp[i] += prod * o[i];
            }
            result += dp[i] * v[i];
          }
          
          Out.println(result);
          return;
        }
    }
}
