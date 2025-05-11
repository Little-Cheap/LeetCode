package 二叉树.P145_二叉树的后序遍历;

public class TreeNode {
     int val;
     public TreeNode left;
    public TreeNode right;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }