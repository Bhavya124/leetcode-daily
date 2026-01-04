class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int count = 0;
            int sumtemp = 0;
            for(int j = 1 ; j*j <= nums[i] ; j++){
                if(nums[i] % j == 0){
                    int x = nums[i] / j;
                    count++;
                    sumtemp = sumtemp + j;
                    if(j != x){
                        count++;
                        sumtemp += x;
                    }
                    if(count > 4)break;
                }
            }
            if(count == 4){
                sum += sumtemp;
            }
        }
        return sum;
    }
}