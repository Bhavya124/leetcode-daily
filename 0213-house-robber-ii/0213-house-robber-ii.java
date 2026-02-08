class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length - 1;
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];
        Arrays.fill(dp , -1);
        Arrays.fill(dp2 , -1);

        return Math.max(calculate(nums , 0 , n - 1 , dp) , calculate(nums , 1 , n , dp2));
    }

    public int calculate(int[] nums,  int ind , int n , int[] dp){
        if(ind > n){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }

        int pick = nums[ind] + calculate(nums , ind + 2 , n ,dp);
        int nonpick = calculate(nums , ind + 1 , n , dp);

        return dp[ind] = Math.max(pick , nonpick);
    }


}