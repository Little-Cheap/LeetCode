package 二叉树.P145_二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null){
            return;
        }
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node1.right = node2;
        node2.left = node3;
        Solution solution = new Solution();
        List<Integer> integers = solution.postorderTraversal(node1);
        integers.forEach(System.out::println);
    }
}