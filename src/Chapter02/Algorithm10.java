package Chapter02;

public class Algorithm10 {
/**
 * @Auther: Wobum
 * @Date: 2018/12/4 16:27
 * @Description: 斐波那契数列
 */
    public static int fib1(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;

        return fib1(n -1) +fib1(n - 2);
    }

    public static long fib2(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int i = 2;
        long fibN1 = 0;
        long fibN2 = 1;
        long res = 0;
        while (i <= n){
            res =  fibN1 + fibN2;
            fibN1 = fibN2;
            fibN2 = res;
            i++;

        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(1000));
    }
}
