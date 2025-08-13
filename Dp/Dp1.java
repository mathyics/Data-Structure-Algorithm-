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

    // fibonacci in tabulation 

    public static int fibTab(int n){// time over 3600
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

    return dp[n];
    }
    public static void main(String[] args) {
        int n=10;
        long startTime=System.nanoTime();
        int result=fibTab(n);
        long endTime=System.nanoTime();

        System.out.println(result);
        System.out.println(endTime-startTime);

        
    }
    
}
