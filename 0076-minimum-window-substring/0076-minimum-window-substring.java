class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        int i = 0;
        int j = 0;
        int reqCount = t.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();
        while(j < n){
            if(map.containsKey(s.charAt(j))){
                if(map.get(s.charAt(j)) > 0){
                    reqCount--;
                }
                map.put(s.charAt(j) , map.get(s.charAt(j)) - 1);
            }
            while(reqCount == 0){
                if(j -i + 1 < minLen){
                    minLen  = j -i + 1;
                    start = i;
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i) , map.get(s.charAt(i))+ 1);
                    if(map.get(s.charAt(i)) > 0){
                        reqCount++;                
                    }
                }
                i++;
            }
            j++;
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start , start + minLen);
    }
}