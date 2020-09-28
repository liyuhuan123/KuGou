package LearnJava_0928;

class TreeNode{
    int val;
    TreeNode root;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class SomeMethod {
    private static int n;
    //树的结点个数
    public static int sumTreeNodeSize(TreeNode root){
        n = 0;
        preOrder(root);
        return n;
    }
    private static void preOrder(TreeNode root){
        if(root != null){
            n++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    private static int sumTreeNodeSize2(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int rootNodeSize = 1;
            int leftSubTreeNodeSize = sumTreeNodeSize2(root.left);
            int rightSubTreeNodeSize = sumTreeNodeSize2(root.right);
            return rootNodeSize + leftSubTreeNodeSize + rightSubTreeNodeSize;
        }
    }
    //计算叶子结点的个数
    private static int leafN;
    public static int sumTreeLeafNodeSize(TreeNode root){
        leafN = 0;
        preOrder2(root);
        return leafN;
    }
    private static void preOrder2(TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                leafN++;
            }
            preOrder2(root.left);
            preOrder2(root.right);
        }
    }
    public static int sumTreeLeafNodeSize2(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else{
            int leftSubTreeLeafSize = sumTreeLeafNodeSize2(root.left);
            int rightSubTreeLeafSize = sumTreeLeafNodeSize2(root.right);
            return leftSubTreeLeafSize + rightSubTreeLeafSize;
        }
    }
    //中序遍历二叉树

    private static void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            System.out.printf("%c",root.val);
            inOrder(root.right);
        }
    }
    private static void preOrder3(TreeNode root){
        if(root != null){
            System.out.printf("%c",root.val);
            System.out.print("{");
            preOrder3(root.left);
            System.out.print("}{");
            preOrder3(root.right);
            System.out.println("}");

        }
    }
    //第K层结点的个数
    private static int sumKLevelNodeSize(TreeNode root,int k){
        if(root == null){
            return 0;
        }else if(k == 1){
            return 1;
        }else{
            int leftSubTreeK_1 = sumKLevelNodeSize(root.left,k - 1);
            int rightSubTreek_1 = sumKLevelNodeSize(root.right,k - 1);
            return leftSubTreeK_1 + rightSubTreek_1;
        }
    }
    //二叉树的高度
    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }else if(root.left == null && root.right == null){
            return 1;
        }else{
            int leftSubTreeHeight = getHeight(root.left);
            int rightSubTreeHeight = getHeight(root.right);
            return Math.max(leftSubTreeHeight,rightSubTreeHeight) + 1;
        }
    }
    //后序遍历二叉树
    private static void postOrder(TreeNode root){
        if(root != null){
            if(root != null){
                postOrder(root.left);
                postOrder(root.right);
                System.out.printf("%c",root.val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.builderTree1();
        int sum = sumTreeNodeSize(root);
        System.out.println("树的结点个数：" + sum);
    }


}
