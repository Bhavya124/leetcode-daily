class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();

        sort(citations.begin() , citations.end());
        int ans = 0;
        for(int i = n - 1 ; i >= 0 ; i--){
            int x = citations[i];
            int store =  n - i;
            if(x >= store){
                ans++;
            }
        }

        return ans;
}
};