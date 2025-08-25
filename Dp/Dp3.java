public class Dp3 {
    public static int coinChange(int[] coins, int amount){
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1; 
        }

        for(int i=1; i <= coins.length; i++) {
            for(int j=1; j <= amount; j++) {
                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static int rodCutting(int[] length, int[] price, int rodLen){
        int n=price.length;
        int dp[][] = new int[n+1][rodLen+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodLen+1;j++){
                if(length[i-1]<=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][rodLen];
    }


    public static int lcs(String s1,String s2, int n,int m){
        if(n==0 || m==0){
            return 0;
        }

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return 1+lcs(s1,s2,n-1,m-1);
        }else{
            int ans1=lcs(s1,s2,n-1,m);
            int ans2=lcs(s1, s2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

     public static int lcs2(String s1,String s2, int n,int m,int dp[][]){
        if(n==0 || m==0){
            return 0;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=lcs(s1,s2,n-1,m-1)+1;
        }else{
            int ans1=lcs(s1,s2,n-1,m);
            int ans2=lcs(s1, s2, n, m-1);
            return dp[n][m]=Math.max(ans1, ans2);
        }
    }

    public static int lcs3(String s1,String s2,int n, int w){
        int dp[][]= new int[n+1][w+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                //check if char matches
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    //not matches
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][w];
    }
    
    public static void main(String[] args) {
        // int[] coins = {1, 2, 5};
        // int amount = 5;
        // System.out.println("Number of ways to make change: " + coinChange(coins, amount));
        
        // int[] length= {1,2,3,4,5,6,7,8};
        // int price[]= {1,5,8,9,10,17,17,20};
        // int rodLen = 8;
        // System.out.println("Maximum profit from rod cutting: " + rodCutting(length, price, rodLen));


        String s1="abcde";
        String s2="ace";
        int n=s1.length();
        int m=s2.length();

        int[][] dp=new int[n+1][m+1];
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<m+1;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        System.out.println("LCS length: " + lcs3(s1, s2, n, m));

        
    }
}
