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
        int n = In.readInt();
        int x = In.readInt();
        double p = In.readDouble();
        double a = In.readDouble();
        double b = In.readDouble();
        double result = 0;

        double p_red = p * a + (1 - p) * b;
        if (x == 1) {
            result = p_red;
        } else if (x == 2) {
            result = a * p / p_red;
        } else if (x == 3) {
            result = 1 - Math.pow(a * p / p_red, n);
        }
        
        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.DOWN);
        Out.println(df.format(result));
    }
}