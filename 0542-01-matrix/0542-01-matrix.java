class pair{
    int row;
    int col;
    pair(int r , int c){
        row = r;
        col = c;
    }
}
class Solution {
    public int[][] directions = new int[][]{
        {0 , 1},
        {0 , -1},
        {1 , 0},
        {-1 , 0},

    };
    public int[][] updateMatrix(int[][] mat) {
        Queue<pair> q = new ArrayDeque<>();
        int n = mat.length;
        int m = mat[0].length;
        int[][]newMat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    newMat[i][j] = 0;
                    q.add(new pair(i, j));
                }
                else{
                    newMat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            pair curr = q.poll();
            for(int[] dir : directions){
                int newRow = dir[0] + curr.row;
                int newCol = dir[1] + curr.col;
                if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) continue;
                if(newMat[newRow][newCol] > newMat[curr.row][curr.col] + 1){
                    newMat[newRow][newCol] = newMat[curr.row][curr.col] + 1;
                    q.add(new pair(newRow , newCol));
                }
            }
        }

        return newMat;
    }
}