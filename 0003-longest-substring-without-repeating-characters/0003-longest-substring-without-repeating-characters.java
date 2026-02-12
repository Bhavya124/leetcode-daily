class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans = Math.max(ans , j - i + 1); 
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;

            }
        }
        return ans;
    }
}