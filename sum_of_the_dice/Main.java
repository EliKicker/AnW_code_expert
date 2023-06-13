import java.math.RoundingMode;
import java.text.DecimalFormat;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");
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
        int n = In.readInt();
        int m = In.readInt();
        int[] u = new int[n];
        int[] v = new int[m];
        for (int i = 0; i < n; ++i) u[i] = In.readInt();
        for (int i = 0; i < m; ++i) v[i] = In.readInt();
        int x = In.readInt();
        int y = In.readInt();
        int z = In.readInt();

        //calc E[X]
        double E_A = 0;
        for (int i = 0; i < n; ++i) E_A += u[i];
        E_A /= n;

        double E_B = 0;
        for (int i = 0; i < m; ++i) E_B += v[i];
        E_B /= m;

        double E = E_A + E_B;

        //calc Pr[A + B > x | A < y]
        double Pr_1 = 0;
        for (int i = 0; i < n; ++i) Pr_1 += (u[i] < y) ? 1 : 0;
        Pr_1 /= n;

        double Pr_2 = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m ; ++j) {
                Pr_2 += (u[i] + v[j] > x && u[i] < y) ? 1 : 0;
            }
        }
        Pr_2 /= n * m;

        double Pr_A_B_x_A_y = Pr_2 / Pr_1;

        //calc
        double E_A_z = 0;
        for (int i = 0; i < n; ++i) E_A_z += (u[i] < z) ? u[i] : 0;
        E_A_z /= n;

        double Pr_3 = 0;
        for (int i = 0; i < n; ++i) Pr_3 += (u[i] < z) ? 1 : 0;
        Pr_3 /= n;

        double E_z = E_A_z * (1 / Pr_3) + E_B;

        // Output using Out.java class
        DecimalFormat df = new DecimalFormat("0.0#####");
        df.setRoundingMode(RoundingMode.DOWN);
        Out.println(df.format(E) + " " + df.format(Pr_A_B_x_A_y) + " " + df.format(E_z));
    }
}