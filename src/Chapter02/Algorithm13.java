package Chapter02;

/**
 * @Author : Wobum
 * @Date : 2019/1/18 20:26
 * @Software : IntelliJ IDEA
 * @Description: 判断机器人可以到达多少个格子
 **/
public class Algorithm13 {
    public static int movingCount(int rows, int cols, int k) {
        if (rows <= 0 || cols <= 0 || k < 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        int count = movingCountCore(visited, rows, cols, 0, 0, k);
        return count;
    }

    public static int movingCountCore(boolean[] visited, int rows, int cols, int row, int col, int k) {
        int count = 0;
        if (check(k, rows, cols, row, col, visited)){
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(visited, rows, cols, row + 1, col, k)
                    + movingCountCore(visited, rows, cols, row - 1, col, k)
                    + movingCountCore(visited, rows, cols, row,  col + 1, k)
                    + movingCountCore(visited, rows, cols, row, col - 1, k);
        }
        return count;
    }

    // 检查当前坐标是否能够进入
    public static boolean check(int k, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= k
                && !visited[row * cols + col])
            return true;

        return false;
    }

    // 返回一个整数的数位和
    public static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(10,1,1));
    }
}
