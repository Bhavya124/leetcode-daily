class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c : letters){
            if(c > target){
                return c;
            }
            if(c == target){
                continue;
            }
        }
        return letters[0];
    }
}