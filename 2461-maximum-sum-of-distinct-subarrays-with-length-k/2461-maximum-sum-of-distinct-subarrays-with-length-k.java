class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i =0;
        int j =0;
        long sum = 0;
        long ans = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        while(j < nums.length){
            sum += nums[j];
            map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);

            if(j - i + 1 < k){
                j++;
            }
            else{
                if(map.size() == k){
                    ans = Math.max(sum , ans);
                }
                sum = sum - nums[i];
                map.put(nums[i] , map.getOrDefault(nums[i] , 0) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
                j++;
            }
        }
        return ans;
        
    }
}