class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(nums.length < 4){
            return false;
        }
        int count = 0;
        int i = 0;
        if(nums[i + 1] <= nums[i]) return false;
        while((i+1<n) && (nums[i + 1] > nums[i])){
            i++;
        }
        if(i + 1 >= n || nums[i + 1] >= nums[i]) return false;
        while((i+1<n) && (nums[i + 1] < nums[i])){
            i++;
        }
        if(i + 1 >= n || nums[i + 1] <= nums[i]) return false;
        while((i+1<n) && (nums[i + 1] > nums[i])){
            i++;
        }
        return i == n - 1;
    }
}