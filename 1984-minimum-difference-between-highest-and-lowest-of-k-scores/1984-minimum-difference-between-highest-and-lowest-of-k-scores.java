class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(k == 1){
            return 0;
        }
        Arrays.sort(nums);
        int maxi = Integer.MAX_VALUE;
        for(int i = 0 ; i < n - k + 1 ; i++){
            int diff = Math.abs(nums[i] - nums[i + k - 1]);
            maxi = Math.min(diff , maxi);
        }
        return  maxi;
    }
}