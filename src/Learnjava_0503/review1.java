package Learnjava_0503;

import java.util.*;

class TreeNode{
    int val;
    TreeNode root;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class review1 {
    //1.编一个程序，读入用户输入的一串先序遍历字符串，
    // 根据此字符串建立一个二叉树（以指针方式存储）。
    // 例如如下的先序遍历字符串：
    // ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
    // 建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = buildTree(line);
            inorder(root);
            System.out.println();
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root + " ");
        inorder(root.right);
    }

    //指定遍历到哪个位置了
    private static int index = 0;

    private static TreeNode buildTree(String line) {
        index = 0;
        return help_build(line);
    }

    private static TreeNode help_build(String line) {
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        root.left = help_build(line);
        index++;
        root.right = help_build(line);
        return root;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            result.add(new ArrayList<>());
            int level_size = queue.size();
            for (int i = 0; i < level_size; i++) {
                TreeNode cur = queue.poll();
                result.get(level).add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            level++;
        }
        return result;
    }

    //最近公共祖先
    private TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid == 2) {
            lca = root;
        }
        return (left + right + mid) > 2;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left == null ? pRootOfTree : left;

    }

    private int index1;//当前访问到先序遍历中的第几个元素了

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index1 = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);

    }

    //[left,right)这个区间就表示当前preorder[index]这个结点对应的子树的中序遍历结果
    private TreeNode buildTreeHelper
    (int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {
            //中序遍历结果为空，这个树就是空树
            return null;
        }
        if (index1 >= preorder.length) {
            //遍历元素结束
            return null;
        }
        //根据当前根结点的值创建出根结点
        TreeNode root = new TreeNode(preorder[index1]);
        index1++;//结点创建完毕，就index++准备处理下一个结点
        //根据该结点在中序遍历结果中的位置，把inorder数组划分成两个部分
        int pos = find(inorder, left, right, root.val);
        //[left,pos)表示当前root左子树的中序遍历结果
        //[pos + 1,right)表示当前root右子树的中序遍历结果
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, right);
        return root;
    }

    private int find
            (int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }
}
