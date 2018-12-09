package Chapter02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Algoritm09 {
    /**
     * @Auther: Wobum
     * @Date: 2018/12/4 15:45
     * @Description: 用栈实现队列，用队列实现栈
     */
    public static class stackToQueue {
        private  Stack<Integer> s1 ;
        private  Stack<Integer> s2 ;

        public stackToQueue(){
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public  int push(int value) {
            s1.push(value);
            return value;
        }

        public int pop() {
            if (s1.isEmpty() && s2.isEmpty()){
                throw new RuntimeException("The queue is empty!");
            }else  if(s2.isEmpty()){
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }
        public int peek() {
            if (s1.isEmpty() && s2.isEmpty()){
                throw new RuntimeException("The queue is empty!");
            }else  if(s2.isEmpty()){
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.peek();
        }


    }

    public static class queueToStack{
        private Queue<Integer> q1;
        private Queue<Integer> q2;

        public queueToStack(){
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        public void push(int value){
            q1.offer(value);
        }

        public int poll(){
            if (q1.isEmpty() && q2.isEmpty()){
                throw new RuntimeException("the Stack is empty!");
            }
            while (q1.size() > 1){
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            swap();
            return res;
        }

        public int peek(){
            if (q1.isEmpty() && q2.isEmpty()){
                throw new RuntimeException("the Stack is empty!");
            }
            while (q1.size() > 1){
                q2.offer(q1.poll());
            }
            int res = q1.poll();
            q2.offer(res);
            swap();
            return res;
        }

        public void swap(){
            Queue<Integer> temp = new LinkedList<>();
            temp  = q1;
            q1 = q2;
            q2 = temp;
        }

    }



    public static void main(String[] args) {
        stackToQueue sq = new stackToQueue();
        sq.push(1);
        sq.push(2);
        System.out.println(sq.pop());
        System.out.println(sq.peek());
        System.out.println(sq.pop());

        queueToStack qs = new queueToStack();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        System.out.println(qs.poll());
        System.out.println(qs.peek());
        System.out.println(qs.poll());

    }
}

