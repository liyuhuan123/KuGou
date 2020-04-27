package Learnjava_0427;

import java.util.*;

public class interview {
    static class TreeNode{
        TreeNode root;
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(TreeNode root) {
            this.root = root;
        }
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

//    public static void main(String[] args) {
//        int x = 20;
//        int y = 5;
//        System.out.println(x+y +""+(x+y)+y);
//    }
    public String toLowerCase(String str) {
        //该函数接收一个字符串参数 str，
    // 并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
    char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++){
        if(arr[i] >= 'A' && arr[i] <= 'Z'){
            arr[i] += 32;
        }
    }
        return new String(arr);
}
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            if(i + k <= length - 1){
                result[i + k] = nums[i];
            }else{
                result[i + k - length] = nums[i];
            }
        }
        System.out.println(Arrays.toString(result));
    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j < nums.length;j++){
            if(nums[j] != val);{
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        System.out.println(removeElement(arr,3));
    }

}
