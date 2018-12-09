package Chapter02;

import java.util.Stack;

public class Algorithm06 {
/**
 * @Auther: Wobum
 * @Date: 2018/12/3 16:20
 * @Description: 输入一个链表的头结点，从头到尾反过来打印出每个节点的值。
 */

    public static class Node{
        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }
    }

    // 采用栈结构,时间复杂度 O(n)，空间复杂度 O(n)
    public static void printLinkedlist1(Node head){
        if(head == null){
            return;
        }

        Stack<Integer> s = new Stack<>();
        Node cur = head;
        while (cur != null){
            s.push(cur.value);
            cur = cur.next;
        }

        while (!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    // 反转链表，时间复杂对 O(n)，空间复杂度 O(1)
    public static void  printLinkedlist2(Node head){
        if (head == null){
            return;
        }

        if (head.next == null){
            System.out.println(head.value);
            return;
        }

        Node cur = head;
        Node pre = null;

        while (cur != null){
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre != null){
            System.out.print(pre.value + " ");
            pre = pre.next;
        }

    }

    // 递归方式
    public static void printListReverseByRecursion(Node head) {
        if (head == null){
            return;
        }

        Node cur = head;
        if (cur.next != null)
            printListReverseByRecursion(cur.next);
        System.out.print(cur.value + " ");

    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printListReverseByRecursion(head);
        System.out.println();
        printLinkedlist1(head);
        System.out.println();
        printLinkedlist2(head);
        System.out.println();
    }
}
