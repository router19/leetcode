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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        return result;
        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode node = null;
        int i =0;
        while(!q.isEmpty())
        {
            node = q.poll();
            
            if(node != null)
            {
                nodes.add(node.val);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);

            }else if(!q.isEmpty())
            {   
                result.add(nodes);
                nodes = new ArrayList<>();
            
                q.add(null);
                i++;
            }    
                    
            }
            result.add(nodes);
            return result;
        }
        

                  
    }
