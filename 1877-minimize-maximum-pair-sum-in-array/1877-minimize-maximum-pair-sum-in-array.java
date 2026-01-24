class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < n / 2 ; i++){
            int sum = nums[i] + nums[n - i - 1];
            maxi = Math.max(sum , maxi);
        }
        return maxi;
    }
}