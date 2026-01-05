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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ;i++){
            map.put(inorder[i] , i);
        }
        return build(0 , inorder.length - 1 , inorder , 0 , postorder.length - 1 , postorder , map);
    }

    public TreeNode build(int is , int ie , int[] inorder , int ps , int pe , int[] postorder , HashMap<Integer, Integer> map){

        if(is > ie || ps > pe){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int inroot = map.get(postorder[pe]);
        int node_val = inroot - is;

        root.left = build(is , inroot - 1 , inorder , ps ,ps + node_val - 1 , postorder , map);
        root.right = build(inroot + 1 , ie , inorder , ps + node_val , pe - 1 , postorder , map);
        
        return root;
    }
}