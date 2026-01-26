class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        int j = 0;
        int mini = Integer.MAX_VALUE;
        while(j < n - 1){
            if(arr[j + 1] - arr[j] <= mini){
                mini = Math.abs(arr[j + 1] - arr[j]);
            }
            j++; 
        }
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