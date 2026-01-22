class Solution {
    public int lengthOfLIS(int[] nums) {
    int[] nums1 = new int[nums.length];
    for(int i = 0 ; i < nums.length ; i++){
        nums1[i] = nums[i];
    }
    
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0 ; i < nums.length ; i++){
        set.add(nums[i]);
    }
    int[] nums2 = new int[set.size()];
    int k = 0;
    for(int it : set){
        nums2[k++] = it;
    }
    Arrays.sort(nums2);
    int n = nums1.length;
    int m = nums2.length;
    int[][] dp = new int[n + 1][m + 1];
    for(int i = 1 ; i < n + 1 ; i++){
        for(int j = 1 ; j < m + 1 ; j++){
            if(nums1[i - 1] == nums2[j - 1]){
                dp[i][j] = 1 + dp[i - 1][j - 1];
            }
            else{
                dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
    }
    return dp[n][m];   
    }
}