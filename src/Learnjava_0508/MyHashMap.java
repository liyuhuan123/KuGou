package Learnjava_0508;
//通过开散列的方式来处理hash冲突

public class MyHashMap {
    //链表的结点
    static class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //负载因子
    private static final double LOAD_FACTOR = 0.75;
    //array就是hash表的本体，数组的每个元素又是一个链表的头结点
    private Node[] array = new Node[101];
    private int size = 0;//表示当前hash表中的元素个数
    //如果key已经存在，就修改当前的value值
    //如果key不存在就插入新的键值对
    private int hashFunc(int key){
        //实际的hashFunction可能会比较复杂
        return key % array.length;
    }
    public void put(int key,int value){
        //1,需要把key映射成数组下标
        int index = hashFunc(key);
        //2.根据下标找到对应的链表
        Node list = array[index];
        //3.当前的key在链表是否存在
        for(Node cur = list;cur != null;cur = cur.next){
            //key已经存在，直接修改value即可
            if(cur.key == key){
            cur.value = value;
            return;}
        }
        //4.如果发现刚才循环结束，没有找到key的结点，直接插入到指定链表的头部
        //此处尾插也完全OK~~~
        Node newNode = new Node(key,value);
        newNode.next = list;
        array[index] = newNode;
        size++;
        if(size / array.length > LOAD_FACTOR){
            resize();
        }
    }
//扩容
    private void resize() {
        Node[]  newArray = new Node[array.length * 2];
        //把原来hash表中的所有元素都搬运到新的数组上
        for(int i = 0;i < array.length;i++){
            for(Node cur = array[i];cur != null;cur = cur.next){
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key,cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
        //让新的数组代替原来的数组
        array = newArray;
    }

    //根据key查找指定元素，如果找到返回对应value，如果没找到，返回null
    public Integer get(int key){
        //1.先计算出key对应的下标
        int index = hashFunc(key);
        //2.根据下标找到对应的链表
        Node list = array[index];
        for(Node cur = list;cur != null;cur = cur.next){
            if(cur.key == key){
                return cur.value;
            }
        }
        return null;
    }

}
