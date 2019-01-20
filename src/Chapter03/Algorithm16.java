package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/20 19:50
 * @Software : IntelliJ IDEA
 * @Description: 实现函数 double Power(double base, int exponent),求 base 的 exponent 次方，不使用库函数,同时不考虑大数字问题
 **/
public class Algorithm16 {
    private static boolean flag = false;

    public static double power(double base, int exponent) {
        // 如果 exponent < 0 ，则 base 不能为 0
        if (equal(base, 0) && exponent < 0) {
            flag = true;
            return 1.0;
        }
        int absExponent = exponent >= 0 ? exponent : -exponent;
        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    public static double powerWithUnsignedExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }

    // 浮点数不能直接用 == 进行判断
    public static boolean equal(double num1, double num2) {
        double temp = num2 - num1;
        if (temp > -0.000001 && temp < 0.000001)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        System.out.println(power(-8, 3));
    }
}
