class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new LinkedHashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int ind = 0;
        for(int n : set){
            nums[ind] = n;
            ind++;
        }

        return ind;
    }
}