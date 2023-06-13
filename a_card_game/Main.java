import algorithms.Algorithms;

import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");
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
        int m = In.readInt();

        double pr = ((double)(n - m) * (n - m - 1) + (n - m) * 2 + (n - m + 1)) / Algorithms.binom(n, m);

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("0.0#######");
        df.setRoundingMode(RoundingMode.DOWN);
        Out.println(df.format(pr));
    }
}