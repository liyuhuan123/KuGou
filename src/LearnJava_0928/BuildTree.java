package LearnJava_0928;

public class BuildTree {
    public static TreeNode builderTree1(){
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = null;
        c.left = e;
        c.right = f;
        d.left = null;
        d.right = g;
        e.left = null;
        e.right = null;
        f.left = h;
        f.right = i;
        g.left = j;
        f.right = null;
        h.left = null;
        return a;

    }
}
