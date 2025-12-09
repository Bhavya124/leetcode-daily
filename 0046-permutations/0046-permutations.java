class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        perma(nums , ans , 0);
        return ans;
    }

    public static void perma(int[] nums , List<List<Integer>> ans , int level){
        if(nums.length == level){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < nums.length ; i++){
                temp.add(nums[i]);
            }
            ans.add(temp);
            return;
        }
        for(int i = level ; i < nums.length ; i++){
            swap(i , level , nums);
            perma(nums , ans , level + 1);
            swap(i , level , nums);
        }
    }
    public static void swap(int a , int b , int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}