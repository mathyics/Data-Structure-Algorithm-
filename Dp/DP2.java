import java.util.*;
public class DP2{
public static int knapsack(int val[], int wt[],int W, int n){
    if(W==0||n==0){
        return 0;
    } 
    if(wt[n-1]<=W){
        int ans1=val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
        int ans2=knapsack(val, wt, W, n-1);
        return Math.max(ans1, ans2);
    }
      
     return knapsack(val, wt, W, n-1);
    

}

public static int knapsackMem(int val[], int wt[],int W, int n,int[][] dp){
    if(W==0||n==0){
        return 0;
    }
    if(dp[n][W]!=-1){
        return dp[n][W];
    }
    if(wt[n-1]<=W){
        int ans1=val[n-1]+knapsackMem(val, wt, W-wt[n-1], n-1,dp);
        int ans2=knapsackMem(val, wt, W, n-1,dp);
        dp[n][W]=Math.max(ans1, ans2);

       return dp[n][W];
    }else{
         dp[n][W]=knapsackMem(val, wt, W, n-1,dp);

     return dp[n][W];
    }
    

}

public static int knapsackTab(int val[], int wt[], int W ){
    int n=val.length;
    int[][] dp=new int[n+1][W+1];
    // initialize first row and first colum as 0
    for(int i=0;i<dp.length;i++){
        dp[i][0]=0;
    }
    for(int i=1;i<dp[0].length;i++){
        dp[0][i]=0;
    }

    for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            int v=val[i-1];
            int w=wt[i-1];
            if(w<=j){
                int include=v+dp[i-1][j-w];
                int exclude=dp[i-1][j];
                dp[i][j]=Math.max(include, exclude);
            }else{
                int exclude=dp[i-1][j];
                dp[i][j]=exclude;
            }
        }
    }
     for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }

    return dp[n][W];
}
public static int Unbound_knapsack(int val[], int wt[], int W ){
    int n=val.length;
    int[][] dp=new int[n+1][W+1];
    // initialize first row and first colum as 0
    for(int i=0;i<dp.length;i++){
        dp[i][0]=0;
    }
    for(int i=1;i<dp[0].length;i++){
        dp[0][i]=0;
    }

    for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            int v=val[i-1];
            int w=wt[i-1];
            if(w<=j){
                int include=v+dp[i][j-w]; // if i item added then i need to fill reamining bag wit i items
                int exclude=dp[i-1][j];
                dp[i][j]=Math.max(include, exclude);
            }else{
                int exclude=dp[i-1][j];
                dp[i][j]=exclude;
            }
        }
    }
     for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }

    return dp[n][W];
}



    public static void main(String[] args) {
     int val[]={15,14,10,45,30};
     int wt[]={2,5,1,3,4};
     int W=7;
     int n=val.length;
    int[][] dp = new int[n+1][W+1];

    for (int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1 ;
        }
    }
    long start=System.nanoTime();
    System.out.println(Unbound_knapsack(val, wt, W));
    long end= System.nanoTime();
    System.out.println(end-start);
 
 }   
}
