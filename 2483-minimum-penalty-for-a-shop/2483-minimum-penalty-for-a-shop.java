class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int []prefixN = new int[n + 1]; 
        int []SuffixY = new int[n + 1];

        for(int i = 1 ;i <= n ; i++){
            prefixN[i] = prefixN[i - 1];
            if(customers.charAt(i - 1) == 'N'){
                prefixN[i]++;
            }
        } 
        for(int i = n- 1 ;i >= 0 ; i--){
            SuffixY[i] = SuffixY[i + 1];
            if(customers.charAt(i) == 'Y'){
                SuffixY[i]++;
            }
        }
        int mini = Integer.MAX_VALUE;
        int bestT = 0;
        for(int i = 0 ;i <= n ; i++){
            if(prefixN[i] + SuffixY[i] < mini){
                mini = SuffixY[i] + prefixN[i];
                bestT = i;
            }
        }
        return bestT; 
    }
}