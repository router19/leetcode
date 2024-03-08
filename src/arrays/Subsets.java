package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets
public class Subsets {
    //Solution : T: O(n * 2^n) , S: O(n * 2^n)
    //https://leetcode.com/problems/subsets/solutions/1766675/java-intuition-of-approach-backtracking/
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubsets(nums,0,new ArrayList<>(), res);
        return res;
    }

    private static void generateSubsets(int nums[], int idx, List<Integer> current, List<List<Integer>> res){
        if(idx == nums.length)
        {
            res.add(new ArrayList<>(current));
            return;
        }

        //Include the current element
        current.add(nums[idx]);
        generateSubsets(nums,idx + 1, current,res);

        //Exclude the element
        current.remove(current.size() -1);
        generateSubsets(nums, idx + 1, current, res);
    }


    public static List<List<Integer>> subsets2(int nums[]){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> res){
        res.add(new ArrayList<>(current));
        for(int i = start;i < nums.length; i++ ){
            current.add(nums[i]);
            backtrack(nums,i+1, current, res);
            current.remove(current.size() -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsets2(new int[]{1,2,3}));
    }
}
