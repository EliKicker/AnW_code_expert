import algorithms.*;
import java.math.BigInteger;
import java.util.Vector;

class Main {
  
    static Vector<Vector<Integer>> ans = new Vector<Vector<Integer>>();
    static Vector<Integer> tmp = new Vector<Integer>();
    static BigInteger[] nums;
  
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
        int k = In.readInt();
        nums = new BigInteger[k];
        for (int i = 0; i < k; ++i) nums[i] = BigInteger.valueOf(In.readInt());
        
        //try
        BigInteger sol = new BigInteger("10000000000");
        BigInteger num = new BigInteger("10000000000");
        for (int i = 1; i <= k; ++i) {
          ans.clear();
          makeCombi(k, 0, i);
          if (i % 2 == 1) {
            for (Vector<Integer> v : ans) {
              sol = sol.subtract(num.divide(lcm(v, 0)));
            }
          } else {
            for (Vector<Integer> v : ans) {
              sol = sol.add(num.divide(lcm(v, 0)));
            }
          }
        }
        
        // Output using Out.java class
        Out.println(sol);
    }
    
    @SuppressWarnings("unchecked")
    static void makeCombi(int n, int left, int k)
    {
        if (k == 0) {
            ans.add(new Vector(tmp));
            return;
        }

        for (int i = left; i < n; ++i) {
            tmp.add(i);
            makeCombi(n, i + 1, k - 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    static BigInteger lcm(Vector idxs, int idx) {
      if (idx == idxs.size() - 1) return nums[(int) idxs.get(idx)];
      BigInteger x = lcm(idxs, idx + 1);
      return nums[(int) idxs.get(idx)].multiply(x).divide(gcd(nums[(int) idxs.get(idx)], x));
    }
    
    static BigInteger gcd(BigInteger a, BigInteger b) {
      BigInteger tmp = BigInteger.ZERO;
      while (b.compareTo(BigInteger.ZERO) != 0) {
        tmp = b;
        b = a.mod(b);
        a = tmp;
      }
      return a;
    }
}
