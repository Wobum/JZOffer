package Chapter02;

/**
 * @Author : Wobum
 * @Date : 2019/1/18 21:49
 * @Software : IntelliJ IDEA
 * @Description: 输入一个整数，输出该数二进制中 1 的个数
 **/
public class Algorithm15 {
    // 只能判断整数
    public static int getNumber1(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1)
                count++;
            num = num >> 1;
        }
        return count;
    }

    public static int getNumber2(int num) {
        int count = 0;
        while (num != 0){
            count++;
            //num & (num - 1) ： 可以将num二进制表示中最右边的1变为0
            num = (num - 1) & num;
        }
        return count;
    }
}
