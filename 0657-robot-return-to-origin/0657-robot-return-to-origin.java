class Solution {
    public boolean judgeCircle(String moves){
        int n = moves.length();
        if(n == 1){
            return false;
        }
        char[] words = moves.toCharArray();
        int count1 = 0;
        int count2 = 0;
        for(char ch : words){
            if(ch == 'U'){
                count1++;
            }
            else if(ch == 'L'){
                count2++;
            }
            else if(ch == 'D'){
                count1--;
            }
            else if(ch == 'R'){
                count2--;
            }
        }
        return count1 == 0 && count2 == 0;
    }
}