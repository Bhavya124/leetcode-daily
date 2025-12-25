class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 2){
            return 0;
        }
        int maxi = 0;
        for(int i = 1; i < nums.length  ; i++){
            int temp = nums[i] - nums[i - 1];
            maxi = Math.max(maxi , temp);
        }
        return maxi;
    }
}