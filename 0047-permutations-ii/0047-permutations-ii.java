class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> ds = new ArrayList<>();
       boolean[] vis = new boolean[nums.length];
       Arrays.sort(nums);
       permu(nums , ans , ds ,vis);
       return  ans;

    }

    public static void permu(int[] nums ,List<List<Integer>> ans, List<Integer> ds ,boolean[] vis){

        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
         for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue;
            vis[i] = true;
            ds.add(nums[i]);
            permu(nums, ans, ds, vis);
            vis[i] = false;
            ds.remove(ds.size() - 1);
        }

    }
}