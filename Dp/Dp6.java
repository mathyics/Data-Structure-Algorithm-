public class Dp6 {

    public static int mcm(int arr[], int i, int j){
        if(i==j)return 0;
        int ans=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost1=mcm(arr, i, k);// A[i-1]*A[k]
            int cost2=mcm(arr, k+1, j);// A[k]*A[j]
            int cost3=arr [i-1]*arr[k]*arr[j];
            int finalCost=cost1+cost2+cost3;    
            ans=Math.min(ans, finalCost);
        }
        return ans;
    }

    public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i==j)return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost1=mcmMem(arr, i, k,dp);// A[i-1]*A[k]
            int cost2=mcmMem(arr, k+1, j,dp);// A[k]*A[j]
            int cost3=arr [i-1]*arr[k]*arr[j];
            ans=Math.min(ans, cost1+cost2+cost3);
        }
        return dp[i][j]=ans;
    }
    
    public static void main(String[] args) {
          int arr[]= {1,2,3,4,3};
            int n=arr.length;
          int dp[][]=new int[arr.length][arr.length];
          for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
            System.out.println(mcmMem(arr, 1, n-1, dp));
    }
}
