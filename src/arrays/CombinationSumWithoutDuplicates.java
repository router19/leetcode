package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii
public class CombinationSumWithoutDuplicates {
    public static List<List<Integer>> combinationSumWithoutDuplicates(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,0,target,new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, int remaining, List<Integer> current, List<List<Integer>> result){
        if(remaining < 0) return;
        if(remaining == 0) result.add(new ArrayList<>(current));

        for(int i= start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;//skip duplicates
            current.add(nums[i]);
            backtrack(nums,i+1,remaining - nums[i], current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSumWithoutDuplicates(new int[]{10,1,2,7,6,1,5},8));
    }

}
