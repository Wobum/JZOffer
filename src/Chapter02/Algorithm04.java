package Chapter02;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class Algorithm04 {
    /**
     * @Auther: Wobum
     * @Date: 2018/12/1 21:01
     * @Description: 查找二维数组
     */

    public static boolean search(int[][] arr, int index) {
        if (arr == null) {
            return false;
        }
        int i = arr[0].length - 1;
        int j = 0;

        while (i >= 0 && j < arr.length) {
            if (arr[i][j] == index) {
                return true;
            } else if (arr[i][j] > index) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(search(arr, 0));
    }
}
