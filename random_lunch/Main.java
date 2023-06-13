import algorithms.*;

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
        int sum = 0;
        int[] probs = new int[n];
        for (int i = 0; i < n; ++i) {
          probs[i] = In.readInt();
          sum += probs[i];
        }
        
        double prob = (probs[0] * probs[0]) / (double) (sum * sum);
        for (int i = 1; i < n; ++i) {
          prob += (probs[0] / (double) (sum - probs[i])) * (probs[i] / (double) sum);
        }
        
        if (q == 1) {
          Out.println(1d - (probs[0] * probs[0]) / (double) (sum * sum));
          return;
        } else if (q == 2) {
          Out.println(prob);
          return;
        } else if (q == 3) {
          double Pr_B_and_A = (probs[1] / (double) sum) * (probs[0] / (double) (sum - probs[1]));
          Out.println(Pr_B_and_A / prob);
          return;
        }
        
        // Output using Out.java class
        Out.println("error");
    }
}
