class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int target = n;
        solve(k , n , ans , temp , 1 , target);
        return ans;
    }

    public void solve(int k , int n ,  List<List<Integer>> ans , List<Integer> temp , int index , int target){
        if(target == 0 && temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = index ; i <= 9  ; i++){
            temp.add(i);
            solve(k , n , ans , temp , i + 1 , target - i);
            temp.remove(temp.size() - 1);
        }
    }
}