class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, ans, 0);
        return ans;
    }
    public  void backtrack(int[] nums , List<List<Integer>> ans , int index){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < nums.length ; i++){
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index ; i < nums.length ; i++){
            swap(nums , i , index);
            backtrack(nums,ans , index + 1);
            swap(nums , i ,index);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}