import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");
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
        int r1 = In.readInt();
        int b1 = In.readInt();
        int r2 = In.readInt();
        int b2 = In.readInt();
        int n = In.readInt();
        int x = In.readInt();
        double result = 0;

        if (x == 1) {
            result = (r1 / (double)(r1 + b1)) * ((r2 + 1) / (double)(r2 + b2 + 1)) + (b1 / (double)(r1 + b1)) * (r2 / (double)(r2 + b2 + 1));
        } else if (x == 2) {
            double t_r_B = (r1 / (double)(r1 + b1)) * ((r2 + 1) / (double)(r2 + b2 + 1));
            double r_B = t_r_B + (b1 / (double)(r1 + b1)) * (r2 / (double)(r2 + b2 + 1));
            result = t_r_B / r_B;
        } else if (x == 3) {
            for (int i = 0; i < n; ++i) result = result + (1 - result) * ((r2 + 1) / (double)(r2 + b2 - i + 1));
        }
        
        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("0.0####");
        df.setRoundingMode(RoundingMode.DOWN);
        Out.println(df.format(result));
    }
}