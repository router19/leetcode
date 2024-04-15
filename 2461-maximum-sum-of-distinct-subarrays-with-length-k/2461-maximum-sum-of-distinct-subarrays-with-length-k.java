class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();

        long sum = 0,maxSum =0;
        int start=0,end=0;

        while (end < nums.length)
        {
            while(set.contains(nums[end])) {
                set.remove(nums[start]);
                sum -= nums[start++];

            }

                sum += nums[end];
            set.add(nums[end]);

            if(end -start + 1 < k){
                end++;
            }

            else if(end - start + 1 ==k){
                maxSum = Math.max(maxSum,sum);
                sum -= nums[start];
                set.remove(nums[start]);
                start++;
                end++;
            }
        }

        return maxSum;
    }
}