package arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/discuss/interview-question/3100856/Fixed-Size-Sliding-Window-(Important-Questions-with-Solutions)
public class MaximumOfAllSubArraySizeK {

    public static int[] maximumOfAll(int[] nums, int k){
        int ans[] = new int[nums.length - k +1];
        Deque<Integer> deque = new LinkedList<>();

        int start=0,end=0,ptr=0;

        while(end < nums.length){
            while(!deque.isEmpty() && deque.peekLast() < nums[end])
                deque.removeLast();

            deque.addLast(nums[end]);

            if(end - start + 1 < k)
                end++;
            else if(end - start + 1 == k){
                ans[ptr++] = deque.peekFirst();

                if(nums[start] == deque.peekFirst())
                    deque.removeFirst();

                start++;
                end++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximumOfAll(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
