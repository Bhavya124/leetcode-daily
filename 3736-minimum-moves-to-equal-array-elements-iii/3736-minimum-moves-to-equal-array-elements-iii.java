class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int maxi = nums[n];
        int count = 0;
        for(int i = 0 ; i <= n ; i++){
            if(nums[i] < maxi){
                count+= maxi - nums[i];
            }
        }
        return count;
    }
}