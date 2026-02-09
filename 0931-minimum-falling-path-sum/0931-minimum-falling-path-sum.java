class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int [] it : dp){
            Arrays.fill(it , -1);
        }
        int mini = Integer.MAX_VALUE;
        for(int i = 0 ;i < n ; i++){
            mini = Math.min(mini ,count(0 , i , m , n , matrix , dp));
        }
        return mini;
    }

    public int count(int i , int j , int m , int n , int[][] matrix ,int[][] dp){
        if(j < 0 || j >= n){
            return Integer.MAX_VALUE;
        }
        if(i == m - 1){
            return matrix[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int left = count(i + 1 , j - 1 , m , n , matrix , dp);
        int between = count(i + 1 , j , m , n , matrix , dp);
        int right = count(i + 1 , j + 1 , m , n , matrix , dp);

        int minleft =  Math.min(left , Math.min(between , right));
        return dp[i][j] = minleft + matrix[i][j];
    }
}