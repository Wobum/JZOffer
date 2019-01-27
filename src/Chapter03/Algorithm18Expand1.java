package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/25 18:06
 * @Software : IntelliJ IDEA
 * @Description: 删除链表中的重复节点，如原链表
 **/
public class Algorithm18Expand1 {
    public static class Node{
        public int value;
        public Node next;
    }

    public static Node deleteRepeatNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 生成新节点，因为头节点有可能被删除
        Node pre = new Node();
        Node tmp = pre;
        pre.next = head;
        Node cur = head;
        // 遍历整个链表
        while (cur != null) {
            // 如果出现重复节点，直接跳过
            if (cur.next != null && cur.value == cur.next.value) {
                while (cur.next != null && cur.value == cur.next.value) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            }else { // 否则，pre 节点移动到 cur
                // pre.next = cur; 如果没有重复节点，pre.next 本就指向 cur，所以这句话没用
                pre = cur;
            }
            cur = cur.next;
        }
        return tmp.next;
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
        Node res = deleteRepeatNode(a);
        printLinkedList(res);
    }
}
