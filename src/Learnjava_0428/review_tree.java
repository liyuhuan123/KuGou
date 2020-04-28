package Learnjava_0428;

import java.util.*;

public class review_tree {
    static class TreeNode{
        TreeNode right;
        TreeNode left;
        TreeNode root;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    //编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。 例如如下的先序遍历字符串：
    // ABC##DE#G##F### 其中“#”表示的是空格，
    // 空格字符代表空树。建立起此二叉树以后，
    // 再对二叉树进行中序遍历，输出遍历结果
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String line = scanner.next();
            TreeNode root = build(line);
            inorderTraversal(root);
            System.out.println();
        }
    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    private static int index = 0;
    private static TreeNode build(String line) {
        index = 0;
        return helper_build(line);
    }

    private static TreeNode helper_build(String line) {
        char cur = line.charAt(index);
        if(cur == '#'){
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        root.left = helper_build(line);
        index++;
        root.right = helper_build(line);
        return root;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            result.add(new ArrayList<Integer>());
            int level_size = queue.size();
            for(int i = 0;i < level_size;i++){
                TreeNode cur = queue.poll();
                result.get(level).add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            level++;

        }
        return result;

    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j < nums.length;j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    public int searchInsert(int[] nums, int target) {
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        for(int i = 0;i < nums.length - 1;i++){
            if(target > nums[i] && target < nums[i + 1]){
                return i+1;
            }
        }
        if(target < nums[0]){
            return 0;
        }
        return nums.length;
    }
    //最近公共祖先
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor
            (TreeNode root, TreeNode p, TreeNode q) {

        //借助递归，搞一个辅助方法进行递归，按照后序遍历的方式递归
        //按照后序遍历的方式递归，递归方法中尝试查找p和q
        if(root == null){
            return null;
        }
        findNode(root,p,q);
        return lca;
    }
//看从root出发能不能找到p或者q
    private boolean findNode
            (TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }
        int left = findNode(root.left,p,q) ? 1 : 0;
        int right = findNode(root.right,p,q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right +mid == 2){
            lca = root;
        }
        return (left + right + mid) > 0;
    }
    public boolean canConstruct
            (String ransomNote, String magazine) {
//简单87给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
// 判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成
// 如果可以构成，返回 true ；否则返回 false
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < magazine.length();i++){
            set.add(magazine.charAt(i));
        }
        for(int i = 0;i < ransomNote.length();i++){
            char cur = ransomNote.charAt(i);
            if(!set.contains(cur)){
                return false;
            }
        }
        return true;
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        //基于递归的方式来完成双向链表构建，为了保证有序性，需要中序遍历
        if(pRootOfTree == null){
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right == null){
            return pRootOfTree;
        }
        //最终的链表 = 左子树的链表 + 根结点 + 右子树的链表
        //就需要用左子树链表的尾巴和跟紧点相连
        //再用右子树的头部和根结点相连
        //1.先递归处理左子树
        //left就是左子树这个链表的根结点
        TreeNode left = Convert(pRootOfTree.left);
        //2.需要找到左子树链表的尾结点
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null){
            leftTail = leftTail.right;
        }
        //循环结束之后，leftTail就指向了左侧链表的尾部
        //3.把左子树和当前结点连在一起
        if(left != null){
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //4.递归转换右子树,把右子树也变成双向链表
        TreeNode right = Convert(pRootOfTree.right);
        //5.把当前结点和右子树连在一起
        if(right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        //6.最终返回新的链表的头结点
        //如果left为null，链表的头结点就是pRootOfTree
        //如果left非null，头结点就是left
        return left == null ? pRootOfTree : left;
    }
//    private int index1;//当前访问到先序遍历结果中的第几个元素了
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        index1 = 0;
//        return builedTreeHelper(preorder,inorder,0,inorder.length);
//    }
//[left,right)这个区间就表示当前preorder[index]这个结点对应的
    //子树的中序遍历结果
//    private TreeNode builedTreeHelper
//            (int[] preorder, int[] inorder, int left,int right) {
//        if(left >= right){
//            //中序遍历结果为空，这个树就是空树
//            return null;
//        }
//        if (index1 >= preorder.length){
//            //遍历元素结束
//            return null;
//        }
//        //根据当前根结点的值创建出根结点
//        TreeNode root = new TreeNode(preorder[index1]);
//        index1++;
//        //根据该结点在中序遍历结果的位置，把inorder数组划分成两个部分
//        int pos = find(inorder,left,right,root.val);
//        //[left,pos)表示当前root左子树的中序遍历结果
//        //[pos + 1,right)表示
//    }
    private int find(int[] inorder, int left,int right,int toFind){
        for(int i = left;i < right;i++){
            if(inorder[i] == toFind){
                return i;
            }
        }
        return -1;
    }
}
