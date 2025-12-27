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
    public int findSecondMinimumValue(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root , ans);
        Collections.sort(ans);
        int first = ans.get(0);
        for(int val : ans){
            if(val != first){
                return val;
            }
        }
        return -1;
    }
    public static void inorder(TreeNode root , ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        inorder(root.left , ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}