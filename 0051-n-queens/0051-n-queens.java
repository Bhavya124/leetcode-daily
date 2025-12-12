class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }


        nqueens(board , 0 , n , ans);

        return ans;
    }


    public static void nqueens(  char[][] board, int row , int  n ,List<List<String>> ans){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(char[] r : board){
                temp.add(new String(r));
            }
            ans.add(temp);
            return;
        }

        for(int j = 0 ; j < n ; j++){
            if(isSafe(board , row , j , n)){
                board[row][j] = 'Q';
                nqueens(board , row  + 1 , n , ans);
                board[row][j] = '.';
            }


        }

    }

    public static boolean isSafe( char[][] board , int row , int  col ,int n){
        for(int i = 0 ; i < board.length ; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row , j = col ; i >= 0 && j >= 0 ; i-- , j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row , j = col ; i >= 0 && j < n ; i-- , j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}