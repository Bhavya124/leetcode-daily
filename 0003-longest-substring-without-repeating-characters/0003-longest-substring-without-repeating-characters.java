
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> st = new HashSet<>();
        int left =0;
        int right = 0;
        while(right<s.length()){
            char ch= s.charAt(right);
            if(!st.contains(s.charAt(right))){
                st.add(s.charAt(right));
                ans = Math.max(ans,right - left + 1);
                right++;
            }
            else{
                st.remove(s.charAt(left));
                left++;
            }
            
        }
        return ans;
    }
}