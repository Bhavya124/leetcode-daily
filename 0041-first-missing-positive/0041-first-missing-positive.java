class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int curr = nums[i] - 1;
            if((nums[i] > 0 && nums[i] <= nums.length) && (nums[curr] != nums[i])){
                swap(nums , curr , i);
            }
            else{
                i++;
            }
        }

        for(int j = 1 ; j <= nums.length; j++){
            if(nums[j - 1] != j){
                return j;
            }
        }

        return nums.length + 1;
    }

    public void swap(int[] nums, int curr , int i){
        int temp = nums[i];
        nums[i] = nums[curr];
        nums[curr] = temp;
    }
}