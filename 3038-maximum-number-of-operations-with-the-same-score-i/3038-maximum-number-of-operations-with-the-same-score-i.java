class Solution {
    public int maxOperations(int[] nums) {
        int len = nums.length;

        if(len < 2)
            return 0;

        int score = nums[0] + nums[1];
        int ops = 1;
        int left = 2,right = len-1;
        while(left < right)
        {
            if(score == nums[left] + nums[left+1]){
                ops++;
                left +=2;
            }
            else
                break;
        } 
        return ops;
    }
}