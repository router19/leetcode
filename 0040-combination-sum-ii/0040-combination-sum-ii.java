class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,0,target,new ArrayList<>(), result);
        return result; 
    }
    private  void backtrack(int[] nums, int start, int remaining, List<Integer> current, List<List<Integer>> result){
        if(remaining < 0) return;
        if(remaining == 0) result.add(new ArrayList<>(current));

        for(int i= start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;//skip duplicates
            current.add(nums[i]);
            backtrack(nums,i+1,remaining - nums[i], current, result);
            current.remove(current.size()-1);
        }
    }
}