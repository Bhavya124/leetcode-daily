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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<pair> q = new ArrayDeque<>();
        int check = image[sr][sc];
        if(check == color) return image;
        image[sr][sc] = color;
        q.add(new pair(sr , sc));
        while(!q.isEmpty()){
            pair curr = q.poll();
            for(int[] dir : directions){
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];

                if(newRow < 0 || newRow >= image.length || newCol < 0 || newCol >= image[0].length) continue;
                if(image[newRow][newCol] == check){
                    image[newRow][newCol] = color;
                    q.add(new pair(newRow , newCol));
                }
            }
        }

        return image;

        

    }
}