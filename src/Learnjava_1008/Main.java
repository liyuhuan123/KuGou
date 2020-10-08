package Learnjava_1008;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class TreeNode {
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

    //https://leetcode-cn.com/problems/binary-tree-preorder-traversal/submissions/
    //二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            List<Integer> leftSubTreeList = preorderTraversal(root.left);
            list.addAll(leftSubTreeList);
            List<Integer> rightSubTreeList = preorderTraversal(root.right);
            list.addAll(rightSubTreeList);
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return helper_preorder(list, root);
    }

    private static List<Integer> helper_preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        helper_preorder(list, root.left);
        helper_preorder(list, root.right);
        return list;
    }

    //https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return helper_inorder(list, root);
    }

    private static List<Integer> helper_inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return list;
        }
        helper_inorder(list, root.left);
        list.add(root.val);
        helper_inorder(list, root.right);
        return list;
    }

    //https://leetcode-cn.com/problems/same-tree/
    //相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //https://leetcode-cn.com/problems/subtree-of-another-tree/
    //另一棵树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return false;
        }
        if (s == null || t == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSameTree(s, t) || isSubtree(s.right, t);
    }

    //判断两棵树是否互为镜像
    private static boolean isMirrorTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return false;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isMirrorTree(p.left, q.right) && isMirrorTree(p.right, q.left);
    }

    //对称二叉树
    //https://leetcode-cn.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper_isSymmetric(root.left, root.right);
    }

    private static boolean helper_isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return helper_isSymmetric(left.left, right.right) && helper_isSymmetric(left.right, right.left);
    }

    //二叉树的最大深度
    //https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //平衡二叉树
    //https://leetcode-cn.com/problems/balanced-binary-tree/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int subb = leftDepth - rightDepth;
        return (subb >= -1 && subb <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
}

