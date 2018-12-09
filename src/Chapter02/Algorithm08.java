package Chapter02;



public class Algorithm08 {
/**
 * @Auther: Wobum
 * @Date: 2018/12/3 20:18
 * @Description: 二叉树的下一个节点
 */
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node father;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node findNextNode(Node node){
        if (node == null){
            return null;
        }
        Node cur = node;
        if (cur.right != null){
            cur = cur.right;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }else {
            while (cur.father != null && cur.father.right == cur){ //
                cur = cur.father;
            }
            return cur.father;
        }
    }

    // for test
    public static void main(String[] args) {
        Node head = new Node(1);
        head.father = null;
        head.left = new Node(2);
        head.left.father = head;
        head.right = new Node(3);
        head.right.father = head;
        head.left.left = new Node(4);
        head.left.left.father = head.left;
        head.left.right = new Node(5);
        head.left.right.father = head.left;
        head.right.left = new Node(6);
        head.right.left.father = head.right;
        head.right.right = new Node(7);
        head.right.right.father = head.right;

        System.out.println(findNextNode(head.right.right));


    }
}
