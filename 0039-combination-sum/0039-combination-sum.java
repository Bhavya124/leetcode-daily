class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        func(candidates, ans, temp , target , 0);
        return ans;
    }

    public void func(int[]candidates ,List<List<Integer>> ans ,List<Integer> temp, int target , int index){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
        }
        if(target < 0){
            return;
        }
        for(int i = index ; i < candidates.length ; i++){
            temp.add(candidates[i]);
            func(candidates , ans , temp , target - candidates[i] , i);
            temp.remove(temp.size() - 1);
        }
    }
}