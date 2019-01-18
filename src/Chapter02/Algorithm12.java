package Chapter02;

/**
 * @Author : Wobum
 * @Date : 2019/1/18 19:28
 * @Software : IntelliJ IDEA
 * @Description: 判断一个矩阵中1是否存在一条包含某个字符串所有字符的路径
 **/
public class Algorithm12 {
    public static boolean hasPath(char[][] matrix, String string) {
        if (matrix == null || string.length() == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 创建 boolen 值数组，使用来判断在一次查找中是否可以访问的，必须要回滚。
        boolean[][] temp = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                temp[row][col] = false;
            }
        }

        // 遍历整个数组判断是否存在路径
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 判断从当前节点开始是否存在路径
                if (hasPathCore(matrix, temp, row, col, index, string)) {
                    return true;
                }
            }
        }

        return false;
    }
    // 判断从当前节点开始是否存在路径
    public static boolean hasPathCore(char[][] matrix, boolean[][] temp, int row, int col, int index, String string) {
        // 只有当 index >= string.length() 时，存在路径
        if (index >= string.length())
            return true;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean flag = false;
        // 如果当前节点对应的字符与字符串对应位置的字符相等,判断下一个字符
        if (col >= 0 && row >= 0 && col <= cols && row < rows && index < string.length()
                && matrix[row][col] == string.charAt(index)
                && !temp[row][col]) {
            index++;
            // 设置 boolean 值矩阵对应位置为 true，表示已经访问过了。
            temp[row][col] = true;

            flag = hasPathCore(matrix, temp, row, col + 1, index, string)
                    || hasPathCore(matrix, temp, row, col - 1, index, string)
                    || hasPathCore(matrix, temp, row + 1, col, index, string)
                    || hasPathCore(matrix, temp, row - 1, col, index, string);
            // 不存在路径，回到上一个字符，重新定位
            if (!flag) {
                index--;
                temp[row][col] = false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        char[][] test = {{'a', 'b', 'f', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        String string = "bfce";
        System.out.println(hasPath(test, string));
    }
}
