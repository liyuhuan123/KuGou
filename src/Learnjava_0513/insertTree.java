package Learnjava_0513;
//二叉搜索树
public class insertTree {
    public class Node{
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node root = null;//为null表示空树
    private boolean insert(int key){
        //不允许存在key相等的元素
        if(root == null){
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node parent = null;//parent始终指向cur的父结点
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                return false;
            }
        }
        if(key < parent.key){
            parent.left = new Node(key);
        }else{
            parent.right =new Node(key);
        }
        return true;
    }
    private boolean remove(int key){
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                removeNode(parent,cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if(cur.left == null){
            //1.要删除的元素没有左子树
            if(cur == root){
                //1.1要删除的结点为root
                root = cur.right;
            }else if(cur == parent.left){
                //1.2cur是parent的左子树
                parent.left = cur.right;
            }else{
                //1.3cur是parent的右子树
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            //2.要删除的元素没有右子树
            if(cur == root){
                //2.1如果要删除结点是root
                root = cur.left;
            }else if(cur == parent.left){
                //2.2要删除结点是父结点的左子树
                parent.left = cur.left;
            }else{
                //2.3要删除节点是父节点的右子树
                parent.right = cur.left;
            }
        }else{
            //3.当前要删除结点有两个子树
            //1)先找到右子树中的额最小元素（替罪羊）
            Node goatParent = cur.right;
            Node scapeGoat = cur.right;
            while(scapeGoat.left != null){
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            //当循环结束时，scapeGoat就指向了右子树的最小值
            //2)把刚才找到的替罪羊结点的值
            cur.key = scapeGoat.key;
            //3)删除替罪羊结点
            //替罪羊结点一定没有左子树
            if(scapeGoat == goatParent.left){
                goatParent.left = scapeGoat.right;
            }else{
                goatParent.right = scapeGoat.right;
            }
        }
    }

    private Node find(int key){
        //存在就返回对应的Node
        Node cur = root;
        while(cur != null){
            if(key < cur.key){
                cur = cur.left;
            }else if(key > cur.key){
                cur = cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }
}
