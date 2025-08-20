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
    public static void main(String[] args) {
        // int[] coins = {1, 2, 5};
        // int amount = 5;
        // System.out.println("Number of ways to make change: " + coinChange(coins, amount));
        
        int[] length= {1,2,3,4,5,6,7,8};
        int price[]= {1,5,8,9,10,17,17,20};
        int rodLen = 8;
        System.out.println("Maximum profit from rod cutting: " + rodCutting(length, price, rodLen));
    }
}
