package Chapter03;

/**
 * @Author : Wobum
 * @Date : 2019/1/28 16:30
 * @Software : IntelliJ IDEA
 * @Description: 调整数组顺序是的奇数在前偶数在后
 **/
public class Algorithm21 {
    public static void reorder(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            // 向后移动直到它指向偶数
            while (low < high && arr[low] % 2 != 0) {
                low++;
            }
            // 向前移动直到它指向奇数
            while (low < high && arr[high] % 2 == 0) {
                high--;
            }

            // 只有在 low < high 的情况下才可以交换
            if (low < high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        printArr(arr);
        reorder(arr);
        printArr(arr);
    }
}
