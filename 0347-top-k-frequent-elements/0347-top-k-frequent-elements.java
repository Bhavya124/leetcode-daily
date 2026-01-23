import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        int[] arr = new int[k];
        int i = 0;
        while(i < k){
            int maxv = Integer.MIN_VALUE;
            int maxk = 0;
            for(Map.Entry<Integer , Integer> entry : map.entrySet()){
                if(entry.getValue() > maxv){
                    maxv = entry.getValue();
                    maxk = entry.getKey();

                }
            }
            arr[i] = maxk;
            map.remove(maxk);
            i++;
        }
        return arr;
    }
}