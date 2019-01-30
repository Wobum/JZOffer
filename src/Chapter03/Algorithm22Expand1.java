package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/30 15:13
 * @Software : IntelliJ IDEA
 * @Description: 求链表的中间节点，如果为偶数，则随便返回一个节点。
 **/
public class Algorithm22Expand1 {
    public static class Node {
        public int value;
        public Node next;
    }

    public static Node getMiddleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printNode(Node node) {
        if (node == null) {
            System.out.println("当前节点不存在");
            return;
        }
        System.out.println("当前节点值为： " + node.value);
    }

    public static void printNodeList(Node head) {
        if (head == null){
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
        System.out.print(cur.value);
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        a.value = 1;
        a.next = b;
        b.value = 2;
        b.next = c;
        c.value = 3;
        c.next = d;
        d.value = 4;
        d.next = e;
        e.value = 5;
        printNodeList(a);
        printNode(getMiddleNode(a));
    }
}
