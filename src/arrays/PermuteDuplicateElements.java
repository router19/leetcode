package arrays;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/permutations-ii/
public class PermuteDuplicateElements {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used){
        if(current.size() == nums.length)
        {
            result.add(new ArrayList<>(current));
        }
        else{
            for(int i=0; i< nums.length; i++){
                // for input {1a, 1b}, there is one valid solution {1a, 1b}, but there will be 2
                // iterations at first stage of backtracking. The valid solution comes in first iteration.
                // In the second iteration we start at 1b.
                // If we dont have above condition then output will contain {1b, 1a} also .
                // So duplicates elements should be considered only once and
                // with !used[i-1] we are eliminating {1b, 1a} by choosing only first occurence of duplicates.
                // So with nums[i-1] == num[i] we are checking if current element is duplicate and
                // with !used[i-1] we are eliminating later occurence of duplicates in output.
                // Same works for {1a, 1b, 1c} there are 3 repeating elements ,
                // we priortize first occurence at each stage of backtracking.
                if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
                used[i] =true;
                current.add(nums[i]);
                backtrack(nums,current,result,used);
                used[i] = false;
                current.remove(current.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }

}
