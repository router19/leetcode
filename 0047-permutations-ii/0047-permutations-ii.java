class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(), result,new boolean[nums.length]);
        return result; 
    }

    private  void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used){
        if(current.size() == nums.length)
        {
            result.add(new ArrayList<>(current));
        }
        else{
            for(int i=0; i< nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] =true;
                current.add(nums[i]);
                backtrack(nums,current,result,used);
                used[i] = false;
                current.remove(current.size() -1);
            }
        }
    }
}