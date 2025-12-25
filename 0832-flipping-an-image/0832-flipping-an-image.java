class Solution {
    public int[][] flipAndInvertImage(int[][] img){
        int n = img.length;
        int m = img[0].length;
        int[][] image = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                image[i][j] = img[i][m-j-1];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(image[i][j] == 0){
                    image[i][j] = 1;
                }
                else if(image[i][j] == 1){
                    image[i][j] = 0;
                }
            }
        }
        return image;
    }
}