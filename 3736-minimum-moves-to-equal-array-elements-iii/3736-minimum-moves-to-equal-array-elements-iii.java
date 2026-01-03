class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length - 1;
        int maxi = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > maxi){
                maxi = nums[i];
            }
        }
        for(int i = 0 ; i <= n ; i++){
            if(nums[i] < maxi){
                count+= maxi - nums[i];
            }
        }
        return count;
    }
}