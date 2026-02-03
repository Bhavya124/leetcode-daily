import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> mpp = new LinkedHashSet<>();

        for(int i = 0 ; i < nums.length ; i++){
            mpp.add(nums[i]);
        }

        int index = 0;
        for(int it : mpp){
            nums[index] = it;
            index++;
        }

        return index;
    }
}