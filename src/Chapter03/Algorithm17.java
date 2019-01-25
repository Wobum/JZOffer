package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/20 21:05
 * @Software : IntelliJ IDEA
 * @Description: 输入数字 n,按顺序打印出从 1 到最大的 n 位十进制
 **/
public class Algorithm17 {
    // 字符数组模拟数字加法实现
    public static void printToMaxOfDigits(int n) {
        if (n <= 0)
            return;
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '0';
        }
        while (!increment(chars)) {
            printCharArr(chars);
        }
    }

    public static boolean increment(char[] chars) {
        // 溢出标志位
        boolean isOverFlow = false;
        // 进位值
        int carry = 0;
        int index = chars.length - 1;

        while (index >= 0) {
            // num 表示当前位置的字符与字符 '0' 的偏移量
            int num = chars[index] - '0' + carry;
            // 如果当前字符位置是个位，直接 ++
            if (index == chars.length - 1) {
                num++;
            }
            // 如果大于 10，产生进位，当前位置置为 0，进入循环
            if (num >= 10) {
                if (index == 0) {
                    isOverFlow = true;
                } else {
                    num = num % 10;
                    carry = 1;
                    chars[index] = '0';
                    index--;
                }
            } else {
                // 小于 10，直接设置，退出循环
                chars[index] = (char) (num + '0');
                break;
            }
        }
        return isOverFlow;
    }

    // 打印字符数组
    public static void printCharArr(char[] chars) {
        boolean begin = false;
        for (int i = 0; i < chars.length; i++) {
            if (!begin && chars[i] != '0')
                begin = true;
            if (begin) {
                System.out.print(chars[i]);
            }
        }
        System.out.println();
    }

    // 全排列进行打印，递归实现
    public static void printToMaxOfDigits1(int n) {
        if (n <= 0)
            return;
        char[] chars = new char[n];
        for (int i = 0; i < 10; i++) {
            chars[0] = (char) (i + '0');
            recursively(chars, n, 0);
        }
    }

    public static void recursively(char[] chars, int length, int index) {
        if (index == length - 1) {
            printCharArr(chars);
            return;
        }
        for (int i = 0; i < 10; i++) {
            chars[index + 1] = (char) (i + '0');
            recursively(chars, length, index + 1);
        }
    }

    public static void main(String[] args) {
        /*char[] arr = {'0','1','0'};
        printCharArr(arr);*/
        printToMaxOfDigits1(2);
    }
}