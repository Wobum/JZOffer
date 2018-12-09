package Chapter02;

public class Algorithm10Expend {
/**
 * @Auther: Wobum
 * @Date: 2018/12/4 16:45
 * @Description: 青蛙上调节问题
 */
    public static int frogUp1(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int i = 3;
        int res = 0;
        int f1 = 1;
        int f2 = 2;

        while (i <= n){
            res = f1 + f2;
            f1 = f2;
            f2 = res;
            i++;
        }

        return res;
    }

    public static int frogUp2(int n){
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return frogUp2(n-1) + frogUp2(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(frogUp1(10));
        System.out.println(frogUp2(10));
    }
}
