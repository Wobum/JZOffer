package Chapter03;


/**
 * @Author : Wobum
 * @Date : 2019/1/30 16:06
 * @Software : IntelliJ IDEA
 * @Description: 合并两个有序链表
 **/
public class Algorithm25 {
    public static class Node {
        public int value;
        public Node next;
    }

    public static Node mergeSortedNodelist(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 != null && head2 == null) {
            return head1;
        }

        if (head1 == null && head2 != null) {
            return head2;
        }

        Node res = new Node();
        Node help = res;
        Node p1 = head1;
        Node p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.value <= p2.value) {
                res.next = p1;
                res = res.next;
                p1 = p1.next;
            } else {
                res.next = p2;
                res = res.next;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            res.next = p1;
            res = res.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            res.next = p2;
            res = res.next;
            p2 = p2.next;
        }

        return help.next;
    }

    public static void printNodeList(Node head) {
        if (head == null) {
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
        Node[] nodes1 = new Node[6];
        Node[] nodes2 = new Node[5];

        int[] arr1 = {1, 3, 3, 4, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 9};
        for (int i = 0; i < nodes1.length; i++) {
            nodes1[i] = new Node();
            nodes1[i].value = arr1[i];
        }

        for (int i = 0; i < nodes1.length - 1; i++) {
            nodes1[i].next = nodes1[i + 1];
        }

        for (int i = 0; i < nodes2.length; i++) {
            nodes2[i] = new Node();
            nodes2[i].value = arr2[i];
        }

        for (int i = 0; i < nodes2.length - 1; i++) {
            nodes2[i].next = nodes2[i + 1];
        }

        printNodeList(nodes1[0]);
        printNodeList(nodes2[0]);

        printNodeList(mergeSortedNodelist(nodes1[0], nodes2[0]));
    }
}
