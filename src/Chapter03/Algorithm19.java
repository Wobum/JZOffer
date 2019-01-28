package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/27 13:32
 * @Software : IntelliJ IDEA
 * @Description: 正则表达式匹配
 **/
public class Algorithm19 {

    // 这个代码是错误的，无法全部完成题目要求
    public static boolean match1(String string, String pattern) {
        if (string == null || pattern == null || string.length() == 0 || pattern.length() == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        // i 和 j 都不越界
        while (i < string.length() && j < pattern.length()) {
            // 不用管下一位
            if ((j + 1 < pattern.length() && pattern.charAt(j + 1) != '*') || j == pattern.length() - 1) {
                if (string.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
                    i++;
                    j++;
                } else
                    return false;
            } else { // 需要管下一位
                if (string.charAt(i) != pattern.charAt(j) && pattern.charAt(j) != '.') {
                    j = j + 2;
                } else {// 这里并不是一定是 i++，由于 * 也可以表示 0 次，这里也有可能是 j = j + 2;
                    i++;
                }
            }
        }
        if (i < string.length() || j < pattern.length())
            return false;
        else
            return true;
    }

    // 递归解决
    public static boolean match(String string, String pattern) {
        if (string == null || pattern == null || string.length() == 0 || pattern.length() == 0) {
            return false;
        }
        return matchCore(string, 0, pattern, 0);
    }


    public static boolean matchCore(String string, int strIndex, String pattern, int pIndex) {
        // string 和 pattern 都操作完，返回 true
        if (strIndex >= string.length() && pIndex >= pattern.length()) {
            return true;
        }

        // string 没有操作完，pattern 操作完了，返回 false
        if (strIndex < string.length() && pIndex >= pattern.length()) {
            return false;
        }

        // string 操作完了，pattern 没有操作完
        if (strIndex >= string.length() && pIndex < pattern.length()) {
            if (pIndex + 1 < pattern.length() && pattern.charAt(pIndex + 1) == '*') {
                return matchCore(string, strIndex, pattern, pIndex + 2);
            } else {
                return false;
            }
        }

        // string 和 pattern 都没有操作完,判断下一位是否为 '*'
        if (strIndex < string.length() && pIndex < pattern.length()) {
            if (pIndex + 1 < pattern.length() && pattern.charAt(pIndex + 1) == '*') {
                // 判断当前状态 string 和 pattern 对应位置上字符是否相等
                if (string.charAt(strIndex) == pattern.charAt(pIndex)) {
                    // 如果相等，则有可能 * 代表 0 次，有可能代表多次
                    return matchCore(string, strIndex, pattern, pIndex + 2)
                            || matchCore(string, strIndex + 1, pattern, pIndex);
                } else {
                    // 如果不相等，* 代表 0 次
                    return matchCore(string, strIndex, pattern, pIndex + 2);
                }
            } else {
                if (string.charAt(strIndex) == pattern.charAt(pIndex) || pattern.charAt(pIndex) == '.') {
                    return matchCore(string, strIndex + 1, pattern, pIndex + 1);
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "aaa";
        String b = "aaa*a*a*a*a";
        System.out.println(match(a, b));
        System.out.println(match1(a, b));
    }
}
