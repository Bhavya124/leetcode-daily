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
        {-1 , 0}
    };
    public int nearestExit(char[][] maze, int[] ent) {
        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(ent[0] , ent[1]));
        maze[ent[0]][ent[1]] = '+';
        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                pair curr = q.poll();
                int row = curr.row;
                int col = curr.col;
                if((row == 0 || col == 0 || row == maze.length - 1|| col == maze[0].length - 1) && !(row == ent[0] && col == ent[1])){
                    return steps;
                }
                for(int [] dir : directions){
                    int newRow = dir[0] + curr.row;
                    int newCol = dir[1] + curr.col;

                    if(newRow < 0 || newCol < 0 || newRow >= maze.length || newCol >= maze[0].length) continue;

                    if(maze[newRow][newCol] == '.'){
                        maze[newRow][newCol] = '+';
                        q.add(new pair(newRow , newCol));
                    }
                }
            }
            steps++;

        }
        return -1;
    }
}