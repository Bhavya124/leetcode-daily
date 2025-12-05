class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int count = 0;
        int k = 0;
        for(int i = 0 ; i <= nums.length - 2 ; i++){
            k += nums[i];
            int j = Math.abs(sum - k);
            if(Math.abs(j - k) % 2 == 0){
                count++;
            } 
        }

        return count;
    }
}