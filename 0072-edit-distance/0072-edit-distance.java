class Solution {
    public int dp[][];
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n + 1][m + 1];
        for(int [] it : dp){
            Arrays.fill(it , 0);
        }
        return solve(word1 , word2 , n , m);
    }

    public int solve(String word1, String word2 , int n , int m){
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        if(dp[n][m] != 0){
            return dp[n][m];
        }
        if(word1.charAt(n - 1) == word2.charAt(m - 1)){
            return solve(word1 , word2 , n - 1 , m - 1);
        }
        int add = 1 + solve(word1 , word2 , n - 1 , m);
        int delete = 1 + solve(word1 , word2, n , m - 1);
        int replace = 1 + solve(word1 , word2 ,n -1 , m - 1);

        return dp[n][m] = Math.min(add , Math.min(delete , replace));
    }
}