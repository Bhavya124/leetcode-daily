class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] it : dp){
            Arrays.fill(it , -1);
        }
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1){
            return 0;
        }
        return count(0 , 0 , m , n , grid , dp);
    }

    public int count(int i , int j , int m , int n , int[][] grid , int[][] dp){
        if(i == m - 1 && j == n - 1){
            return 1;
        }
        if(i >= m || j >= n){
            return 0;
        }
        if(grid[i][j] == 1){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = count(i + 1 , j , m , n , grid , dp);
        int bottom = count(i , j + 1 , m , n , grid , dp);

        return dp[i][j] =  right  + bottom;
    }
}