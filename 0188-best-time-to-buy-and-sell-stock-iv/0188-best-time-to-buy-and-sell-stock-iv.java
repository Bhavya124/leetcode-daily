class Solution {
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][2][k + 1];
       for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < 2 ; j++){
            Arrays.fill(dp[i][j] , -1);
        }
       }

       return count(0 , n , 1 , k , arr , dp);
    }
    public int count(int ind , int n , int day , int trans , int[] arr , int[][][] dp){
        if(ind == n || trans == 0){
            return 0;
        }
        if(dp[ind][day][trans] != -1){
            return dp[ind][day][trans];
        }

        if(day == 1){
            int take = -arr[ind] + count(ind + 1 , n , 0 , trans ,arr , dp);
            int nontake = count(ind + 1 , n , 1 , trans ,arr , dp);
            return dp[ind][day][trans] = Math.max(take ,nontake);
        }
        else{
            int sell = arr[ind] + count(ind + 1 , n , 1 , trans - 1 , arr , dp);
            int nonsell = count(ind + 1 , n , 0 , trans , arr , dp);
            return dp[ind][day][trans] = Math.max(sell , nonsell);
        }
    }
}