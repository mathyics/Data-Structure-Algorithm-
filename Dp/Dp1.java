import  java.util.*;

public class Dp1 {
    public static int fib(int n){// time  over 15000 ns
        if(n==0||n==1){
            return n;
        }

        return fib(n-1)+fib(n-2);
    }
    public static int fib(int n, int fib[]){ //time over 4800ns very optimized
        if(n==0||n==1){
            return n;
        }

        if(fib[n]!=0){
            return fib[n];
        }
        fib[n]=fib(n-1,fib)+fib(n-2,fib);

        return fib[n];
    }
    public static void main(String[] args) {
        int n=10;
        long startTime=System.nanoTime();
        int result=fib(n,new int[n+1]);
        long endTime=System.nanoTime();

        System.out.println(result);
        System.out.println(endTime-startTime);

        
    }
    
}
