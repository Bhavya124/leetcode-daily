class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][]dp = new int[m][n][n];
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return count(0 , 0 , n - 1 , grid , dp);
    }

    public int count(int row , int col1 , int col2 , int[][] grid , int[][][] dp){
        if(col1 < 0 || col1 >= grid[0].length
        || col2 < 0 || col2 >= grid[0].length){
            return Integer.MIN_VALUE;
        }
        int cherry;
        if(col1 == col2){
            cherry = grid[row][col2];
        }
        else{
            cherry = grid[row][col1] + grid[row][col2];
        }
        if(row == grid.length - 1){
            return cherry;
        }

        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = -1 ; i <= 1 ; i++){
            for(int j = -1 ; j <= 1 ; j++){
                maxi = Math.max(maxi , count(row + 1, col1 + i , col2 + j , grid ,dp));
            }
        }
        return dp[row][col1][col2] = cherry + maxi;
    }
}