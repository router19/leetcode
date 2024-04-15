package arrays;

import java.util.HashSet;
import java.util.Set;

public class MaxSumOfDistinctArrays {

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        long sum = 0,maxSum =0;
        int start=0,end=0;

        while (end < nums.length)
        {
            //Two case to think of for window of k=3,
            //arr = 4,2,4,1, start would change to 2 in this case at idx 1
            //arr = 4,4,2,1 , start would change to 2 in this case at idx = 2
            //arr = 4,4,4,2,1 start would move to4 at  idx=2
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

    public static void main(String[] args) {

        System.out.println(maximumSubarraySum(new int[]{5,3,3,1,1},3));

    }
}
