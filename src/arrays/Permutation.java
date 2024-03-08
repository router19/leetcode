package arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations
public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
        }
        else{
            for(int i=0; i< nums.length; i++){
                if(current.contains(nums[i])) continue;
                current.add(nums[i]);
                backtrack(nums,current,result);
                current.remove(current.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
