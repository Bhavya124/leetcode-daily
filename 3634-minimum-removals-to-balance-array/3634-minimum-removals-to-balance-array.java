class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int len = 0;
        int n = nums.length;

        for(int j = 0 ; j < n ; j++){
            while(i < j && nums[j] > (long)nums[i] * k){
                i++;
            }
            len = Math.max(len , j - i + 1);
        }
        return n - len;
    }
}