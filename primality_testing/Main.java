import algorithms.*;
import java.util.Random;
import java.math.BigInteger;

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
        long n = In.readLong();
        
        if (n == 2) {
          Out.println("yes");
          return;
        }
        if ((n & 1) == 0 || n == 1) {
          Out.println("no");
          return;
        }
        
        Random r = new Random();
        long a, x, t;
        
        for (int i = 0; i < 3; ++i) {
          while ((a = Math.abs(r.nextLong()) % n) < 2);
          x = n - 1;
          if (mod_pow(a, x, n) == 1 && gcd(a, n) == 1) {
            x >>= 1;
            while ((t = mod_pow(a, x, n)) == 1) {
              if ((x & 1) == 0) x >>= 1;
              else break;
            }
            if (t == 1 || t == n - 1) continue;
            Out.println("no");
            return;
          } else {
            Out.println("no");
            return;
          }
        }
        
        Out.println("yes");
    }
    
    //calc a ^ b mod m with assumption a < m
    private static long mod_pow(long a, long b, long m) {
      long x = 1;
      while (b > 0) {
        if ((b & 1) == 1) x = mod_mult(a, x, m);
        a = mod_mult(a, a, m);
        b >>= 1;
      }
      return x;
    }
    
    //calc a * b mod m with assumption a < m
    private static long mod_mult(long a, long b, long m) {
      long x = 0;
      while (b > 0) {
        if ((b & 1) == 1 && (x += a) >= m) x -= m;
        if ((a <<= 1) >= m) a -= m;
        b >>= 1;
      }
      return x;
    }
    
    //calc gcd(a, b)
    private static long gcd(long a, long b) {
      long x = 0;
      while (b > 0) {
        x = b;
        b = a % b;
        a = x;
      }
      return a;
    }
}
