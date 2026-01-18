class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        function(ans, ds, s, 0);
        return ans;
    }

    public static void function(List<List<String>>ans ,List<String> ds , String s , int index){
        if(s.length() == index){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index ; i < s.length() ; i++){
            String temp = s.substring(index , i + 1);

            if(isPali(temp)){
                ds.add(temp);
                function(ans , ds , s , i+ 1);
                ds.remove(ds.size() - 1);
            }
        }
    }

    public static boolean isPali(String temp){
        for(int i = 0 ; i  < temp.length() - 1 ; i++){
            if(temp.charAt(i) != temp.charAt(temp.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}