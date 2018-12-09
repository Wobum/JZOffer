package Chapter02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Algorithm03 {
/**
 * @Auther: Wobum
 * @Date: 2018/12/1 18:35
 * @Description: 在一个长度为 n 的数组中所有的数字都在 0 ~ n - 1 的范围内，数组中某些数字是重复的，但不知道有几个数字重读了，也不
 *                知道每个数字重复了几次，请找出数组中任意一个重复的数字。
 */

    // 通过排序加遍历的方式，时间复杂度 O(nlogn)
    public static int findRepeatNum1(int[] arr){
        if (arr == null){
            return -1;
        }
        Arrays.sort(arr); // O(nlogn)
        for (int i = 0; i < arr.length - 1; i++){ // O(n)
            if (arr[i] == arr[i + 1]){
                return arr[i];
            }
        }
        return -1;
    }

    // 通过 hashset 时间复杂度 O(n)，空间复杂度 O(n)
    public static int findRepeatNum2(int[] arr){
        if (arr == null){
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr){
            if (set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    // 时间复杂度 O（n），空间复杂度 O(1)
    public static int findRepeatNum3(int[] arr){
        if (arr == null){
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return -1;
            }
        }
        for (int i = 0; i < arr.length; i++){
            while (arr[i] != i){
                if(arr[i] == arr[arr[i]]){
                    return arr[i];
                }
                swap(arr, i, arr[i]); // 如果当前数 n 不等于下标 i，则交换坐标为 i 和 n 的数。
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j){
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr.length - 1){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test
    // 生成长度为 length，数组内数字范围为 0 ~ length - 1 的数组
    public static int[] generationRandomArr(int length){
        if (length < 1){
            return null;
        }
        int [] arr = new int[length -1];
        for (int i = 0; i < length - 1; i++){
            arr[i] = (int) (Math.random() * (length - 1));
        }
        return arr;
    }

    public static void printArr(int[] arr){
        if (arr == null){
            return;
        }
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = generationRandomArr(10);
        printArr(arr);
        System.out.println();
        System.out.println(findRepeatNum1(arr));
        System.out.println();
        System.out.println(findRepeatNum2(arr));
        System.out.println();
        System. out.println(findRepeatNum3(arr));

    }
}
