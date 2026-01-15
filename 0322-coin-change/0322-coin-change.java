class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];
        for(int[] it : dp){
            Arrays.fill(it , -1);
        }

        int ans = solve(coins , amount , 0);
        return ans >= (int)1e9 ? -1:  ans;
    }

    public int solve(int[] coins , int a , int ind){
        if(ind == coins.length - 1){
            if(a % coins[ind] == 0){
                return a / coins[ind];
            }
            else{
                return(int)1e9;
            }
        }
        if(dp[ind][a] != -1){
            return dp[ind][a];
        }

        int nontake = 0 + solve(coins , a , ind + 1);
        int take = Integer.MAX_VALUE;
        if(coins[ind] <= a){
            take = 1 + solve(coins , a - coins[ind] , ind);
        }

        return dp[ind][a] = Math.min(nontake , take);

    }
}