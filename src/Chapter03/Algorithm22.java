package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/30 14:53
 * @Software : IntelliJ IDEA
 * @Description: 链表中倒数第 K 个节点
 **/
public class Algorithm22 {
    public static class Node {
        public int value;
        public Node next;
    }

    public static Node getNode(Node head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        Node pre = head;
        Node cur = head;
        // cur 向前走 k 步
        for (int i = 0; i < k; i++) {
            if (cur != null)
                cur = cur.next;
            else
                return null;
        }

        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }

    public static void printNode(Node node) {
        if (node == null) {
            System.out.println("当前节点不存在");
            return;
        }
        System.out.println("节点值为 " + node.value);
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
        printNode(getNode(null, 1));
    }
}
