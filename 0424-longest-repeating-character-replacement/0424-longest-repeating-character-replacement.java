class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxlen= 0;
        int maxFreq = 0;

        for(int right =  0 ; right <= s.length() - 1 ; right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq , freq[ch - 'A']);

            int windowlen = right - left + 1;
            if(windowlen - maxFreq > k){
                char leftchar = s.charAt(left);
                freq[leftchar - 'A']--;
                left++;
                windowlen = right - left + 1;
            }
            maxlen = Math.max(maxlen , windowlen);
        }
        return maxlen;
    }
}