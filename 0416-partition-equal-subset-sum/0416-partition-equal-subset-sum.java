class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){
            sum += arr[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for(int[] it : dp){
            Arrays.fill(it , -1);
        }
        if(check(arr , n , 0 , sum / 2 , dp) == 1){
            return true;
        }
        return false;
    }
        public int check(int[] arr , int n , int ind , int target , int[][] dp){
        if(target == 0){
            return 1;
        }
        if(ind == n){
            return 0;
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int take = 0;
        if(arr[ind] <= target){
            take = check(arr, n , ind + 1 , target - arr[ind] , dp);
        }
        int nontake = check(arr, n , ind + 1 , target , dp);

        return dp[ind][target] = Math.max(take , nontake);
    }
}