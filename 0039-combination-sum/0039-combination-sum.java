class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,0,target,new ArrayList<>(), result);
        return result;
    }
    private  void backtrack(int[] nums, int start, int remaining, List<Integer> current, List<List<Integer>> result){
        if(remaining < 0) return;
        if(remaining == 0) result.add(new ArrayList<>(current));

        for(int i= start; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(nums,i,remaining - nums[i], current, result);
            current.remove(current.size()-1);
        }
    }
}