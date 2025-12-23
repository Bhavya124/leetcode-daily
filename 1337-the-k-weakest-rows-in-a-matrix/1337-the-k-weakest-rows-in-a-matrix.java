class pair{
    int index;
    int sum;
    pair(int i , int s){
        index = i;
        sum = s;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a , b) -> {
            if(a.sum != b.sum)
                return a.sum - b.sum;
                return a.index - b.index;
            }
        );
        for(int i = 0 ; i < mat.length ; i++){
            int sum = 0;
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 1)
                sum = sum + mat[i][j];
            }
            pq.add(new pair(i , sum));
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++){
            pair curr = pq.remove();
            ans[i] = curr.index;
        }
        return ans;

    }
}