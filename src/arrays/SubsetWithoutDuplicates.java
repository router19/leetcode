package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/description/
public class SubsetWithoutDuplicates {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0 , new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int nums[], int start, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++)
        {
            if(i > start && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            backtrack(nums,i+1,current,result);
            current.remove(current.size()-1);
        }
    }


    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }

}
