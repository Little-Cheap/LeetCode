package 分治;

import 二叉树.P145_二叉树的后序遍历.TreeNode;

import java.util.HashMap;

/**
 * 构建树问题
 * 通过已经前序遍历以及中序遍历的结果，构建树
 * 思路：
 * 1. 确定根节点：前序遍历的第一个元素就是根节点 记为索引  i [3,9,2,1,7]
 * 2. 确定根节点：中序序遍历的根节点 记为索引  m [9,3,1,2,7]
 * 3. 中序遍历的索引范围  [l,r]
 * <p>
 * 根在前序中的索引：
 * 根节点 i
 * 左子节点 i+1
 * 右子节点 i+1+根节点左侧节点数量 即i+1+(m-l)
 * <p>
 * 子节点在中序中的索引范围：
 * 根节点 [l,r]
 * 左子节点 [l,m-1]
 * 右子节点 [m+1,r]
 */
public class 构建树问题 {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 2, 1, 7};
        int[] inorder = {9, 3, 1, 2, 7};
        TreeNode treeNode = new 构建树问题().buildTree(preorder, inorder);
    }

    public static TreeNode dfs(int[] preorder, HashMap<Integer, Integer> inorderMap, int i, int l, int r) {
        if (r < l) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[i]);
        int m = inorderMap.get(preorder[i]);
        rootNode.left = dfs(preorder, inorderMap, i + 1, l, m - 1);
        rootNode.right = dfs(preorder, inorderMap, i + 1 + (m - l), m + 1, r);
        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return dfs(preorder, inorderMap, 0, 0, inorder.length - 1);
    }
}
