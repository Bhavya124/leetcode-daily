class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                String sub = s.substring(i , j + 1);
                if(isNice(sub)){
                    if(sub.length() > ans.length()){
                        ans = sub;
                    }
                }
            }
        }
        return ans;

    }

    public boolean isNice(String sub){

        HashSet<Character> set = new HashSet<>();
        for(char c : sub.toCharArray()){
            set.add(c);
        }

        for(char ch : sub.toCharArray()){
            if(Character.isLowerCase(ch)){
                if(!set.contains(Character.toUpperCase(ch))){
                    return false;
                }
            }
            else{
                if(!set.contains(Character.toLowerCase(ch))){
                    return false;
                }
            }
        }
        return true;
    }
}