import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");
        Out.setEpsilon(0.0000001);
        
        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int r = In.readInt();
        int g = In.readInt();
        int b = In.readInt();
        int m = In.readInt();
        int x = In.readInt();
        int y = In.readInt();
        int z = In.readInt();

        long m_combinations = Algorithms.binom(r + g + b, r + g + b - m);
        long xyz_combinations = Algorithms.binom(r, x) * Algorithms.binom(g, y) * Algorithms.binom(b, z);

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("#.########");
        df.setRoundingMode(RoundingMode.DOWN);
        Out.println(df.format((double)xyz_combinations / m_combinations));
    }
}