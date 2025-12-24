class pair{
    int val;
    int index;
    pair(int v , int i){
        val =  v;
        index = i;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a , b) -> b.val - a.val
        );
        int n = nums.length;
        int[] arr = new int[n -k+1];
        for(int i = 0 ; i < k ; i++){
            pq.add(new pair(nums[i] , i));
        }
        arr[0] = pq.peek().val;
        for(int i = k ; i < n ; i++){
            pq.add(new pair(nums[i] , i));
            while(pq.peek().index <= i - k){
                pq.poll();
            }
            arr[i -k + 1] = pq.peek().val;
        }
        return arr;             
    }
}