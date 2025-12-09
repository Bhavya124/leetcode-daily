class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n ; i++){
            nums[i] = i + 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums , ans ,temp , 0 , k);
        return ans;
    }

    public static void solve(int[] nums , List<List<Integer>> ans , List<Integer> temp, int index , int k){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index < nums.length){
        temp.add(nums[index]);
        solve(nums , ans , temp , index + 1 , k);
        temp.remove(temp.size() - 1);
        solve(nums , ans , temp , index + 1 , k);
        }
    }
}