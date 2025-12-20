class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        int n = strs.length;
        int m = strs[0].length();
        int i = 0;
        while(i < m){
            StringBuilder store = new StringBuilder();
            for(int j = 0 ; j < n ; j++){
                store.append(strs[j].charAt(i));
            }
            if(!check(store.toString())) count++;
            i++;
        }
        return count;
    }

    public boolean check(String s){
        boolean flag = true;
        for(int i = 0 ; i < s.length() - 1 ; i++){
            if(s.charAt(i) > s.charAt(i + 1)){
                flag = false;
            }
        }
        return flag;
    }
}