package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/3100856/Fixed-Size-Sliding-Window-(Important-Questions-with-Solutions)
// Find First Negative element of each sub-array of size k.
// (return answer in form of an array or list and in case there is no negative element in the sub-array of size k,
// then put a 0 for that sub-array)
public class FirstNegativeInWindowSizeK {

    public static int[] firstNegativeInWindow(int[] nums, int k){
        int start =0,end =0,ptr =0;
        Queue<Integer> negatives = new LinkedList<>();
        int[] ans = new int[nums.length -k +1];
        while(end < nums.length)
        {
            if(nums[end] < 0)
            {
                negatives.add(nums[end]);
            }
            if(end - start + 1 < k){
                end++;
            }
            else if(end - start + 1 == k){
                if(negatives.isEmpty()){
                    ans[ptr++] = 0;
                }
                else{
                    ans[ptr++] = negatives.peek();

                    if(nums[start] == negatives.peek())
                        negatives.remove();
                }
                start++;
                end++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstNegativeInWindow(new int[]{12, -1, -2, 8, -16, 30, 16, 28},3)));
    }
}
