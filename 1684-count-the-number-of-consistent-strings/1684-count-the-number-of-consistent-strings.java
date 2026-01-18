class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()){
            set.add(c);
        }
        for(String word : words){
            boolean flag = true;
            for(int i = 0 ; i < word.length() ; i++){
                if(!set.contains(word.charAt(i))){
                    flag = false;
                    break;
                }
            }
            if(flag)count++;
        }

        return count;
    }
}