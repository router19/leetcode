package arrays;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/?envType=featured-list&envId=top-interview-questions?envType=featured-list&envId=top-interview-questions
 */
public class SortedArrayToBST {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(){};
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode createTree(int[] nums, int start, int end){
        if(start > end )
            return null;
        int mid = start + (end -start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,start,mid -1);
        root.right = createTree(nums,mid + 1 , end);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortedArrayToBST sor = new SortedArrayToBST();
        TreeNode node = sor.sortedArrayToBST(nums);
        System.out.println(node);
    }

}
