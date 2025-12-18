class pair{
    int row;
    int col;
    int dis;
    pair(int r , int c , int d){
        row = r;
        col = c;
        dis = d;
    }
}
class Solution {
    int[][] directions = new int[][]{
        {-1, -1},
        {-1, 0},
        {-1, 1},
        {0, -1},
        {0, 1},
        {1, -1},
        {1, 0},
        {1, 1},
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
      int n = grid.length;
      if(grid[0][0] == 1){
        return -1;
      }  
      if(grid[n - 1][n - 1] == 1){
        return -1;
      }
      Queue<pair> q = new ArrayDeque<>();
      q.add(new pair(0 , 0 , 1));
      grid[0][0] = 1;
      while(!q.isEmpty()){
        pair curr = q.poll();
        if(curr.row == n - 1 && curr.col == n - 1){
            return curr.dis;
        }
        for(int[] dir : directions){
            int newRow = curr.row + dir[0];
            int newCol = curr.col + dir[1];

            if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= n) continue;
            if(grid[newRow][newCol] == 0){
                q.add(new pair(newRow , newCol , curr.dis + 1));
                grid[newRow][newCol] = 1;
            }
        }
      }
      return -1;
    }
}