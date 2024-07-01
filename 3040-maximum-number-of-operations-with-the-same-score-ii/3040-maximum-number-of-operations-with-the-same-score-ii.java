class Solution {
    public int maxOperations(int[] nums) {
        int maxOperations = 0;
        int len = nums.length ;
        int dp[][] = new int[len][len];

        int start = 0;
        int end = len -1;

        maxOperations = Math.max(maxOperations, 1 + findMaxOperations(nums,start +2,end,nums[start] + nums[start + 1], dp));
        maxOperations = Math.max(maxOperations, 1 + findMaxOperations(nums,start +1,end-1,nums[start] + nums[end], dp));
        maxOperations = Math.max(maxOperations, 1 + findMaxOperations(nums,start ,end-,nums[end] + nums[end - 1], dp));

        return maxOperations;

    }


    int findMaxOperations(int[] nums, int start, int end, int sum, int[][] dp)
    {
        if(start >= end)
            return 0;
        if(dp[start][end] != 0)
            return dp[start][end];


        int max = 0;
        if(nums[start] + nums[start +1 ] == sum)
            max = Math.max(max, 1+ findMaxOperations(nums,start + 2,end, sum, dp));
        if(nums[start] + nums[end] == sum)
            max = Math.max(max, 1+ findMaxOperations(nums,start + 1,end-1, sum, dp));
        if(nums[end] + nums [end-1] == sum)
            max = Math.max(max, 1+ findMaxOperations(nums,start ,end-2, sum, dp));

        return dp[start][end] = max;
    }
}