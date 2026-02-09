class Solution {
    public int uniquePaths(int m, int n) {
        //IS Question me dekha jaye to mere pass 2
        //hi options hain
        int[][] dp = new int[m][n];
        for(int[] it : dp){
            Arrays.fill(it , -1);
        }
        return countWays(0 , 0 , m , n , dp);
    }

    public int countWays(int i , int j , int m , int n , int[][] dp){
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        if(i >= m || j >= n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = countWays(i + 1 , j , m , n , dp);
        int bottom  =  countWays(i , j + 1 , m , n , dp);

        return dp[i][j] = right + bottom;
    }
}