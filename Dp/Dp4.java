import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dp4 {

    public static int LCSub(String s1,String s2 ){
        int n=s1.length();
        int m= s2.length();

        int dp[][]= new int[n+1][m+1];
        int ans=0;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans, dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
                
            }
        }

        return ans;
    }

     public int lengthOfLIS(int[] nums) {
        Set<Integer> set= new HashSet<>();
       
       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       }

       int nums2[]=new int[set.size()];

       int m=0;
       for(int key:set){
        nums2[m]=key;
        m++;
       }

       Arrays.sort(nums2);

        int n=nums.length;
       int k=nums2.length;
        int dp[][]=new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(nums[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }


        return dp[n][k];
        
    }
    public static void main(String[] args) {
        String s1="ABCDE";
        String s2="ABGCE";
        System.out.println(LCSub(s1,s2));
    }
    
}
