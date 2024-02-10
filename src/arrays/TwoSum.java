package arrays;

import java.util.*;

/**
 * LeetCode Problem : https://leetcode.com/problems/two-sum/solutions/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 */
public class TwoSum {


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexMap = new HashMap<>();

        for (int itr =0; itr < nums.length;  itr++){
            if((indexMap.containsKey(target - nums[itr]) ))
            {
                return new int[]{indexMap.get(target - nums[itr]),itr};
            }
            indexMap.put(nums[itr],itr);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int nums[] ={2,7,11,15};
        int[] indexes = twoSum(nums,9);
        System.out.println("["+indexes[0]+","+indexes[1]+"]");
    }
}
