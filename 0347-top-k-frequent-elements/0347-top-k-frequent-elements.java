class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] keyval = new int[map.size()][2];
        int i = 0;
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            if(i != map.size()){
                keyval[i][0] = entry.getKey();
                keyval[i][1] = entry.getValue();
            }
            i++;
        }
        Arrays.sort(keyval , (a , b) -> Integer.compare(b[1] , a[1]));
        int[] arr = new int[k];
        for(int l = 0 ; l < k ; l++){
            arr[l] = keyval[l][0];
        }
        return arr;
    }
}