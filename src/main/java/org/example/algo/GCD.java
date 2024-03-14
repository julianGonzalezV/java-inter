package org.example.algo;

public class GCD {

   static int gcdByBruteForce(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
       System.out.println("GCD =>"+gcd);
        return gcd;
    }

    public static void main(String[] args) {
        gcdByBruteForce(24, 36);
    }
}
