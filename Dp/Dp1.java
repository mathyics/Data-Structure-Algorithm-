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

    public static int fibTab(int n){// time 1900
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

    return dp[n];
    }
    public static int climbStairsMem(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=climbStairsMem(n-1, dp)+climbStairsMem(n-2, dp);
        return dp[n];

    }
    public static void main(String[] args) {
        int n=10;
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        long startTime=System.nanoTime();
        int result=climbStairsMem(n, dp);
        long endTime=System.nanoTime();

        System.out.println(result);
        System.out.println(endTime-startTime);

        
    }
    
}
