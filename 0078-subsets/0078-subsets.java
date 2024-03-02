class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }
     private void generateSubsets(int[] nums, int start, List<Integer> current, List<List<Integer>> res) {
        res.add(new ArrayList<>(current));
        for(int i = start;i < nums.length; i++ ){
            current.add(nums[i]);
            generateSubsets(nums,i+1, current, res);
            current.remove(current.size() -1);
        }
    }
}