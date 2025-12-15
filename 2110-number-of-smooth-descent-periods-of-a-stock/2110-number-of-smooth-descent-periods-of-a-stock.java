class Solution {
    public long getDescentPeriods(int[] prices) {
        //lets start with the brute force;
        int count = 0;
        int n = prices.length;
        long[] dp = new long[n];
        dp[0] = 1;
        long ans = 1;
        for(int i = 1 ; i < n ; i++){
            if(prices[i] == prices[i - 1] - 1){
                dp[i] = dp[i - 1] + 1;
            }
            else{
                dp[i] = 1;
            }
            ans += dp[i];
        }
        return ans;
    }
}