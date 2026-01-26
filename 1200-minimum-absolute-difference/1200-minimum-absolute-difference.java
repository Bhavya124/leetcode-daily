class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        int mini = Math.abs(arr[1] - arr[0]);
        while(i < n - 1){
            if(arr[i + 1] - arr[i] == mini){
                List<Integer>temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                ans.add(temp);
            }
            i++; 
        }
        return ans;
    }
}