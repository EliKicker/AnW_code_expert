import java.util.Arrays;

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
        int n = In.readInt();
        int m = In.readInt();
        ConvexHull ch = new ConvexHull();
        Point[] roses = new Point[n];
        String result = "";
        for (int i = 0; i < n; ++i) roses[i] = new Point(In.readInt(), In.readInt());
        ch.init(roses);
        for (int i = 0; i < m; ++i) {
            if (ch.inside(new Point(In.readInt(), In.readInt()))) result += "y";
            else result += "n";
        }
        Out.println(result);
    }

    private static class ConvexHull {
        Point[] wrap;
        private boolean left(Point A, Point B, Point C) { return (B.x - A.x) * (C.y - A.y) >= (B.y - A.y) * (C.x - A.x); }
        public void init(Point[] p) {
            Arrays.sort(p);
            Point[] q = new Point[p.length << 1];
            q[0] = p[0];
            int h = 0;
            for (int i = 1; i < p.length; ++i) {
                while (h > 0 && left(q[h], q[h - 1], p[i])) --h;
                q[++h] = p[i];
            }
            int k = h;
            for (int i = p.length - 2; i >= 0; --i) {
                while (h > k && left(q[h], q[h - 1], p[i])) --h;
                q[++h] = p[i];
            }
            wrap = Arrays.copyOfRange(q, 0, h);
        }
        public boolean inside(Point p) {
            for (int i = 0; i < wrap.length - 1; ++i) if (!left(p, wrap[i], wrap[i + 1])) return false;
            return left(p, wrap[wrap.length - 1], wrap[0]);
        }
    }

    private static class Point implements Comparable<Point> {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Point o) {
            if (x != o.x) return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
        }
    }
}