package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/30 17:39
 * @Software : IntelliJ IDEA
 * @Description: 输入两棵树 A 和 B，判断 B 是不是 A 的子结构
 **/
public class Algorithm26 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean getResult(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return false;
        }
        return hasSubtree(head1, head2);
    }

    public static boolean hasSubtree(Node head1, Node head2) {
        boolean flag = false;
        if (head1 != null && head2 != null) {
            if (head1.value == head2.value)
                flag = process(head1, head2);
            if (!flag)
                flag = hasSubtree(head1.left, head2);
            if (!flag)
                flag = hasSubtree(head1.right, head2);
        }
        return flag;
    }

    public static boolean process(Node head1, Node head2) {
        if (head2 == null)
            return true;
        if (head1 == null)
            return false;
        if (head1.value != head2.value)
            return false;
        return process(head1.left, head2.left) && process(head1.right, head2.right);
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        Node node = new Node(3);
        node.left = new Node(2);
        node.right = new Node(4);

        System.out.println(getResult(head, node));

    }
}
