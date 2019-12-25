package com.leo.study.coding;

/**
 * 二叉树平衡检查
 * <p>
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * <p>
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 *
 * @author chao.li@quvideo.com
 * @date 2019/12/20 15:34
 */
public class No18 {
    public boolean isBalance(TreeNode root) {
        // write code here
        return checkBalance(root);
    }

    /**
     * 通过递归判断
     *
     * @param node
     * @return
     */
    private boolean checkBalance(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left == null && hasGrandson(node.right)) {
            return false;
        }
        if (node.right == null && hasGrandson(node.left)) {
            return false;
        }
        return checkBalance(node.left) && checkBalance(node.right);
    }

    private boolean hasGrandson(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left != null) {
            if (node.left.left != null || node.left.right != null) {
                return true;
            }
        }
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null) {
                return true;
            }
        }
        return false;
    }
}
