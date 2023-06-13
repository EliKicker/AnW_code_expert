class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test2.in");
        Out.compareTo("public/test2.out");

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
        int[] h = new int[n];
        for (int i = 0; i < n; ++i) h[i] = In.readInt();

        //Greedy
        int max = 1;
        for (int i = 0; i < n; ++i) {
            if (max < i + 1 || max >= n) break;
            max = Math.max(max, h[i] + i);
        }
        
        // Output using Out.java class
        Out.println(Math.min(n, max));
    }
}