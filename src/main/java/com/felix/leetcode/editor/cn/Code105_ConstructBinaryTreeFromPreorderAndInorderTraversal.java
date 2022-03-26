//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
//
//
// 示例 1:
//
//
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均无重复元素
// inorder 均出现在 preorder
// preorder 保证为二叉树的前序遍历序列
// inorder 保证为二叉树的中序遍历序列
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1380 👎 0


package com.felix.leetcode.editor.cn;

import java.util.HashMap;

public class Code105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Code105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        //解1
        public TreeNode buildTree1(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length)
                return null;

            return f(preorder, 0, inorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode f(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2) {
            if (L1 > R1)
                return null;
            TreeNode treeNode = new TreeNode(preorder[L1]);
            if (L1 == R1)
                return treeNode;
            int find = L2;
            while (inorder[find] != preorder[L1]) {
                find++;
            }
            treeNode.left = f(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1);
            treeNode.right = f(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2);
            return treeNode;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length != inorder.length)
                return null;
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++)
                hashMap.put(inorder[i], i);

            return g(preorder, 0, inorder.length - 1, inorder, 0, inorder.length - 1, hashMap);
        }


        private TreeNode g(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, HashMap<Integer, Integer> hashMap) {
            if (L1 > R1)
                return null;
            TreeNode treeNode = new TreeNode(preorder[L1]);
            if (L1 == R1)
                return treeNode;
            int find = hashMap.get(preorder[L1]);
            treeNode.left = g(preorder, L1 + 1, L1 + find - L2, inorder, L2, find - 1, hashMap);
            treeNode.right = g(preorder, L1 + find - L2 + 1, R1, inorder, find + 1, R2, hashMap);
            return treeNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
