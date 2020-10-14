package Learnjava_1014;
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
//链表的头插、尾插、头删、尾删
public class Operation {
    public static Node headInsert(Node head,int e){
        Node newNode = new Node(e);
        newNode.next = head;
        return newNode;
    }
    public static Node tailInsert(Node head,int e){
        if(head == null){
            return headInsert(head,e);
        }else{
            Node newNode = new Node(e);
            Node last = getLast(head);
            last.next = newNode;
            return head;
        }
    }
    private static Node getLast(Node head){
        Node cur = head;
        while(cur != null){
            cur = cur.next;
        }
        return cur;
    }
    public static Node headDelete(Node head){
        if(head == null){
            System.out.println("参数不合法");
            return null;
        }else{
            return head.next;
        }
    }
    private static Node getLastLast(Node head){
        Node node = head;
        while(node.next.next != null){
            node = node.next;
        }
        return node;
    }
    public static Node tailDelete(Node head){
        if(head == null){
            System.out.println("参数不合法");
            return null;
        }
        if(head.next == null){
            return null;
        }else{
            Node lastLast = getLastLast(head);
            lastLast.next = null;
            return head;
        }

    }
}
