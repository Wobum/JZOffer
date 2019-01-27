package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/27 11:57
 * @Software : IntelliJ IDEA
 * @Description: 删除链表中的重复节点，使得链表中的节点值每个只出现一次。
 **/
public class Algorithm18Expand2 {
    public static class Node {
        public int value;
        public Node next;
    }

    // 时间复杂度为 O(1)，空间复杂度为 O(1)
    public static void deleteRepeatNode(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node cur = head;
        while (cur != null) {
            if (cur.next != null && cur.value == cur.next.value) {
                Node tmp = cur;
                while (tmp.next != null && tmp.value == tmp.next.value) {
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            }
            cur = cur.next;
        }
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        while (head.next != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.print(head.value);
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        a.next = b;
        a.value = 1;
        b.next = c;
        b.value = 1;
        c.next = d;
        c.value = 3;
        d.next = e;
        d.value = 3;
        e.next = f;
        e.value = 4;
        f.next = g;
        f.value = 4;
        g.value = 5;

        printLinkedList(a);
        deleteRepeatNode(a);
        printLinkedList(a);
    }
}
