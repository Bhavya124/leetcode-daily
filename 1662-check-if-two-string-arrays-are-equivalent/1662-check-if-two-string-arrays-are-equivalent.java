import java.util.*;
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String first = "";
        String sec = "";
        for(String c : word1){
            first += c;
        }
        for(String c : word2){
            sec += c;
        }
        if(first.equals(sec)) return true;
        return false;
    }
}