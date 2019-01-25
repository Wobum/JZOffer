package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/25 17:21
 * @Software : IntelliJ IDEA
 * @Description: 在 O(1) 时间复杂度下删除链表中的节点
 **/
public class Algorithm18 {
    public static class Node {
        public Node next;
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteNode(Node head, Node cur) {
        if (head == null || cur == null) {
            return head;
        }

        if (cur.next != null) {
            cur.value = cur.next.value;
            cur.next = cur.next.next;
        } else {
            // cur.next == null && head == cur
            if (head == cur) {
                head = null;
            } else {
                Node node = head;
                while (node.next != cur) {
                    node = node.next;
                }
                node.next = null;
            }
        }
        return head;
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
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(5);
        Node d = new Node(6);
        Node e = new Node(7);
        Node f = new Node(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        printLinkedList(f);
        /*
        这里需要给将结果返回给 f ，否则 f 所指向的地址不会发生改变。
        Java 方法中，对于基本数据类型，实现的是传值，只是个形参，不会改变原来的值，对于引用数据，
        对这个引用进行操作，其实也是相当于传值操作，不会改变原来的引用，但是，当对这个引用的属性
        进行操作的时候，相当于 CPP 中的传址调用，可以改变这个引用的属性的值。
        */
        f = deleteNode(f, f);
        printLinkedList(f);
    }
}
