package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/28 15:02
 * @Software : IntelliJ IDEA
 * @Description: 判断一个字符串是否表示的是数字，数字的格式可以是 A.[.[B]][e|EC] 或者 .B[e|EC]，其中 A 为数值的整数部分，
 *               B 紧跟着小数点为数值的小数部分，C 紧跟着 'e' 或 'E' 为数值的指数部分
 **/
public class Algorithm20 {
    // 声明一个全局变量，表示当前扫描的位置
    private static int index;

    public static boolean isNumeric(String string) {
        if (string == null || string.length() == 0)
            return false;

        index = 0;
        // 对 A 部分进行检测，flag 为 false 表示 A 部分有误或者没有 A 部分
        boolean flag = scanInteger(string);
        // 判断有没有 '.'，如果有，则表示有 B 部分，
        if (index < string.length() && string.charAt(index) == '.') {
            index++;
            // 扫描 B 部分，如果有 '.' 表示小数部分，
            flag = scanUnsignedInteger(string) || flag;
        }

        // 判断有没有 'e' 或者 'E'，如果有，则表示有 E 部分。
        if (index < string.length() && (string.charAt(index) == 'e' || string.charAt(index) == 'E')) {
            index++;
            // 扫描 C 部分
            flag = scanInteger(string) && flag;
        }
        return index >= string.length() && flag;
    }

    // 扫描可能以 '+' 或 '-' 为起始的 0~9 的数位，用来匹配前面数值模式中的 A 和 C 部分
    public static boolean scanInteger(String string) {
        if (string.charAt(index) == '+' || string.charAt(index) == '-')
            index++;
        return scanUnsignedInteger(string);
    }

    // 扫描字符串中的 0~9 部分，可以用来匹配数值模式中的 B 部分
    public static boolean scanUnsignedInteger(String string) {
        int temp = index;
        while (index < string.length() && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
            index++;
        }
        return index > temp;
    }

    public static void main(String[] args) {
        String s = "12e+5";
        System.out.println(isNumeric(s));
    }

}
