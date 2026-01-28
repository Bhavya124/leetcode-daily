class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int n = s.length() / 2;
        String a = s.substring(0 , n);
        String b = s.substring(n , s.length());

        int count = 0;
        for(int i = 0 ; i < a.length() ; i++){
            if(check(a.charAt(i))){
                count++;
            }
        } 
        for(int i = 0 ; i < a.length() ; i++){
            if(check(b.charAt(i))){
                count--;
            }
        }
        if(count == 0) return true;
        return false; 
    }

    public boolean check(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}