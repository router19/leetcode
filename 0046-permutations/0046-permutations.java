class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,new ArrayList<>(), result);
        return result; 
    }
    private  void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result){
        if(nums.length == current.size()){
            result.add(new ArrayList<>(current));
        }
        else{
            for(int i =0; i< nums.length; i++){
                if(current.contains(nums[i])) continue;
                current.add(nums[i]);
                backtrack(nums,current,result);
                current.remove(current.size()-1);
            }
        }
    }
}