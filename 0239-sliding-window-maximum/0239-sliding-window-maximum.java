class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = nums.length;
        int[] arr = new int[n -k+1];
        for(int i = 0 ; i < k ; i++){
            pq.add(nums[i]);
        }
        arr[0] = pq.peek();
        for(int i = k ; i < n ; i++){
            pq.remove(nums[i - k]);
            pq.add(nums[i]);
            arr[i -k + 1] = pq.peek();
        }
        return arr;             
    }
}