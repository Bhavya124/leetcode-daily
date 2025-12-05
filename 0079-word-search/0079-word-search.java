class Solution {
    public int[][] directions = new int[][]{
        {-1, 0},
        {1,0},
        {0,-1},
        {0,1}
    };
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j  = 0;j < m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board , word , 0,  i ,  j)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word , int ind , int i , int j){
        if(ind == word.length() - 1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for(int[] dir : directions){
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if(newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length){
                continue;
            }

            if(board[newRow][newCol] == word.charAt(ind + 1)){
                if(dfs(board , word , ind + 1,  newRow ,  newCol)){
                    return true;
                }
            }
        }
        board[i][j] = temp;
        return false;
    }
}