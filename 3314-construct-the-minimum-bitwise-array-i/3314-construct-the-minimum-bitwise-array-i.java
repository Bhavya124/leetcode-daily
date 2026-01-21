class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            boolean flag = false;
            for(int j = 1 ; j <= num - 1 ; j++){
                if((j | (j + 1)) == num){
                    ans.add(j);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans.add(-1);
            }
        }
        int[] arr = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}