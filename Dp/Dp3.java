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
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println("Number of ways to make change: " + coinChange(coins, amount));

    }
}
