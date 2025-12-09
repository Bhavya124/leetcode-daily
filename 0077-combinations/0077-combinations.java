class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(ans , temp , 1 ,  n , k);
        return ans;
    }

    public static void solve(List<List<Integer>> ans , List<Integer> temp,int start , int n , int k){
        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start ; i<= n - (k - temp.size()) + 1 ; i++){
            temp.add(i);
            solve(ans , temp , i + 1 , n , k);
            temp.remove(temp.size() - 1);
        }
    }
}