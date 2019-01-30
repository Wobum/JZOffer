package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/30 15:27
 * @Software : IntelliJ IDEA
 * @Description: 如果一个链表中含有环，返回入环节点。
 **/
public class Algorithm23 {
    public static class Node{
        public int value;
        public Node next;
    }

    public static Node getMettingNode(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow ;
            }
        }
        return null;
    }

    public static Node getLoopnode(Node head) {
        if (head == null) {
            return null;
        }
        Node mettingNode = getMettingNode(head);
        if (mettingNode != null){
            Node slow = mettingNode;
            Node fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    public static void printNode(Node node) {
        if (node == null) {
            System.out.println("当前节点不存在");
            return;
        }
        System.out.println("当前节点值为 " + node.value);
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
        // e.next = c;

        printNode(getLoopnode(null));
    }
}
