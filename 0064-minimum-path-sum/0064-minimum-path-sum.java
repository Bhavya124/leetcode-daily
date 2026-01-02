class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m =  grid[0].length;
        int[][]dp = new int[n + 1][m + 1];
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                dp[a][b] = -1;
            }
        }
        return solve(grid ,0 ,0 , dp);
    }

    public int solve(int[][] grid , int i , int j , int[][]dp){
        if(i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(grid , i + 1 , j , dp);
        int right = solve(grid , i , j + 1 , dp);
        return dp[i][j] = grid[i][j] + Math.min(down ,right);
    }
}