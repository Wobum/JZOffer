package Chapter02;

/**
 * @Author : Wobum
 * @Date : 2018/12/13 22:21
 * @Software : IntelliJ IDEA
 * @Description: 一个旋转数组，找出该数组中的最小值。
 **/
public class Algorithm11 {
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new RuntimeException("参数错误!");
        int left = 0;
        int right = arr.length - 1;
        int indexMin = 0; // 初始化为 0
        if (arr[left] < arr[right])
            return arr[left];
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[left])
                left = mid;
            else if (arr[mid] < arr[left])
                right = mid;
            else
                return minElement(arr);
        }
        return arr[indexMin];
    }

    public static int minElement(int[] arr) {
        int result = arr[0];
        for (int i : arr) {
            if (i < arr[0])
                result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 1, 2};
        int[] arr2 = {0, 1, 2, 3, 4};
        int[] arr3 = {1, 0, 1, 1, 1};
        int[] arr4 = {1, 1, 1, 0, 1};
        int[] arr5 = {1, 1, 0, 1, 1};
      /*  System.out.println(findMin(arr1));
        System.out.println(findMin(arr2));
        System.out.println(findMin(arr3));
        System.out.println(findMin(arr4));*/
        System.out.println(findMin(arr5));
    }
}
