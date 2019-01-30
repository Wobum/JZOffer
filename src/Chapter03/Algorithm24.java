package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/30 15:53
 * @Software : IntelliJ IDEA
 * @Description: 反转链表
 **/
public class Algorithm24 {
    public static class Node {
        public int value;
        public Node next;
    }

    public static Node reverseNodelist(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
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
        c.next= d;
        d.value = 4;
        d.next = e;
        e.value = 5;

        printNodeList(a);
        Node head = reverseNodelist(a);
        printNodeList(head);
    }
}
