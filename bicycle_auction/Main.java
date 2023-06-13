class Main {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");
        
        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int c = In.readInt();
        int b = In.readInt();
        Algorithms.Graph G = new Algorithms.Graph(c + b + 2);
        for (int i = 0; i < b; ++i) G.addEdge(c + b, i + c, 1);
        for (int i = 0; i < c; ++i) {
            int x = In.readInt();
            for (int j = 0; j < x; ++j) G.addEdge(In.readInt() + c - 1, i, 1);
            G.addEdge(i, c + b + 1, 1);
        }

        // Output using Out.java class
        Out.println(G.computeMaximumFlow(c + b, c + b + 1));
    }
}