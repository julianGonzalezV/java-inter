package org.example.algo;

public class Fibo {

    public static int fibo(int n){
        int result = 0;
        for (int i=0; i<=n; i++){
            result+=i;
        }
        return result;
    }

    public static void main(String... args){
        System.out.println(fibo(4));
    }
}
