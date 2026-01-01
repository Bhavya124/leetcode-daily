class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp , -1);
        return solve(dp, nums , target);
    }

    public int solve(int[] dp , int[] nums , int target){
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(dp[target] != -1) return dp[target];
        int count = 0;

        for(int num : nums){
            count += solve(dp , nums , target - num);
        }
        return dp[target] = count;
    }
}