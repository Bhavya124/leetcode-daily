class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if(oldColor == color){
            return image;
        }
        flood(image , sr , sc , color ,oldColor ,  image.length , image[0].length);
        return image;
    }

    public void flood(int[][] image , int sr , int sc , int color, int oldColor, int n , int m){
        if(sr < 0 || sc < 0 || sr >= n || sc >= m){
            return;
        }
        if(image[sr][sc] != oldColor){
            return;
        }
        image[sr][sc] = color;
        flood(image , sr + 1 , sc , color , oldColor , n , m);
        flood(image , sr - 1 , sc , color , oldColor , n , m);
        flood(image , sr , sc + 1 , color , oldColor , n , m);
        flood(image , sr , sc - 1 , color , oldColor , n , m);

    }
}