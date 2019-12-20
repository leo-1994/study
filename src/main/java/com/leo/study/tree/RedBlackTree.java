package com.leo.study.tree;

/**
 * @author chao.li@quvideo.com
 * @date 2019-06-17 14:05
 */
public class RedBlackTree {
    private TreeNode treeHead;

    private int size = 0;

    class TreeNode {

        int data;

        TreeNode parent;

        TreeNode left;

        TreeNode right;

        boolean red;

        TreeNode(TreeNode parent, int data) {
            this.parent = parent;
            this.data = data;
            this.red = this.parent != null;
        }
    }

    /**
     * 节点左旋
     */
    private TreeNode leftRotate(TreeNode node) {
        if (node.right == null) {
            throw new RuntimeException("右节点为空，无法左旋");
        }
        TreeNode parent = node.parent;
        boolean isLeft = isLeft(node);
        TreeNode rightChild = node.right;
        TreeNode leftChild = rightChild.left;
        rightChild.left = node;
        node.right = leftChild;
        node.parent = rightChild;
        rightChild.parent = parent;
        if (parent != null) {
            if (isLeft) {
                parent.left = rightChild;
            } else {
                parent.right = rightChild;
            }
        }
        return rightChild;
    }

    /**
     * 节点右旋
     */
    private TreeNode rightRotate(TreeNode node) {
        if (node.left == null) {
            throw new RuntimeException("左节点为空，无法右旋");
        }
        TreeNode parent = node.parent;
        boolean isLeft = isLeft(node);
        TreeNode leftChild = node.left;
        TreeNode rightChild = node.right;
        leftChild.right = node;
        node.left = rightChild;
        node.parent = leftChild;
        leftChild.parent = parent;
        if (parent != null) {
            if (isLeft) {
                parent.left = leftChild;
            } else {
                parent.right = leftChild;
            }
        }
        return leftChild;
    }

    /**
     * 节点变色
     *
     * @param node 节点
     */
    private void changeColor(TreeNode node) {
        if (node == null) {
            return;
        }
        node.red = !node.red;
    }

    /**
     * 判断节点是否在父节点的左侧
     *
     * @param node 节点
     * @return true在左，false在右
     */
    private boolean isLeft(TreeNode node) {
        if (node.parent == null) {
            return false;
        } else {
            return node.parent.left == node;
        }
    }

    public void add(int data) {
        // 如果头节点为空，则直接new一个头节点
        if (treeHead == null) {
            treeHead = new TreeNode(null, data);
            size++;
            return;
        }
        TreeNode child;
        boolean left;
        // 如果不为空，循环找到合适的位置
        for (TreeNode curr = treeHead; ; ) {
            if (data < curr.data) {
                if (curr.left == null) {
                    child = curr.left = new TreeNode(curr, data);
                    left = true;
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    child = curr.right = new TreeNode(curr, data);
                    left = false;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        size++;
        // 父节点
        TreeNode f;
        // 祖父节点
        TreeNode g;
        // 叔叔节点
        TreeNode u;
        // 插入后进行旋转和变色操作
        while ((f = child.parent) != null && (g = f.parent) != null) {
            if (!f.red) {
                // 如果父节点是黑色，则无需操作
                return;
            }
            boolean fLeft = isLeft(f);
            if (fLeft) {
                u = g.right;
            } else {
                u = g.left;
            }
            // 如果叔叔为空或者叔叔为黑
            if (u == null || !u.red) {
                if (left ^ fLeft) {
                    // 如果父在左子在右或父在右子在左，对父亲旋转
                    if (left) {
                        f = rightRotate(f);
                    } else {
                        f = leftRotate(f);
                    }
                }
                // 对父亲和祖父变色
                changeColor(f);
                changeColor(g);
                // 对祖父进行旋转
                if (fLeft) {
                    g = rightRotate(g);
                } else {
                    g = leftRotate(g);
                }
                if (g.parent == null) {
                    treeHead = g;
                    treeHead.red = false;
                }
                return;
            } else {
                // 如果叔叔为红色
                // 爸爸，叔叔，祖父都变色
                changeColor(f);
                changeColor(g);
                changeColor(u);
                if (g.parent == null) {
                    treeHead = g;
                    treeHead.red = false;
                    return;
                } else {
                    // 循环迭代去除双红
                    child = g;
                }
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrderTraverse(TreeNode node) {
        if (node == null) {
            System.out.println("NIL");
            return;
        }
        System.out.println(node.data + " " + getColor(node));
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public int size() {
        return size;
    }

    private String getColor(TreeNode node) {
        if (node.red) {
            return "red";
        } else {
            return "black";
        }
    }


    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        for (int i = 0; i <= 100; i++) {
            tree.add(i);
        }
        tree.preOrderTraverse(tree.treeHead);
    }

}
