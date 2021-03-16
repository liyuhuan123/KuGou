package Learnjava_21_0316;

import java.util.ArrayList;

public class 序列化二叉树 {
    ArrayList<Integer> list = new ArrayList<>();
    TreeNode n = null;
    String Serialize(TreeNode root) {
        n = root;
        return "test";
    }
    TreeNode Deserialize(String str) {
        return n;
    }
}
