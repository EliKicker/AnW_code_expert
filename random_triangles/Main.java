import algorithms.*;

class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");

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
        double p = In.readDouble();
        
        double E = (n * (n - 1) * (n - 2) / 6) * Math.pow(p, 3);
        double Var = E + (n * (n - 1) * (n - 2) / 6) * (3 * (n - 3) * Math.pow(p, 5) + 3 * ((n - 3) * (n - 4) / 2) * Math.pow(p, 6) + ((n - 3) * (n - 4) * (n - 5) / 6) * Math.pow(p, 6)) - Math.pow(E, 2);

        // Output using Out.java class
        Out.println(E + " " + Var);
    }
}
