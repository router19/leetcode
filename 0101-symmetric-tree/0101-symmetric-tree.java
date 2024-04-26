/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    boolean isMirrorUtil(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 != null && root2 != null && root1.val == root2.val)
          return isMirrorUtil(root1.left,root2.right) && isMirrorUtil(root1.right,root2.left);    

        return false;  
    }
    public boolean isSymmetric(TreeNode root) {
        return isMirrorUtil(root,root);
                
    }
}