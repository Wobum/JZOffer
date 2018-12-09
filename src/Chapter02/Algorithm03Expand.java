package Chapter02;

import java.time.format.SignStyle;

public class Algorithm03Expand {
/**
 * @Auther: Wobum
 * @Date: 2018/12/1 19:44
 * @Description: 在一个长度为 n 的数组里的所有数字都在 1 ~ n - 1 范围内，找出数组中任意一个重复数组，但不能修改输入数组。
 */

    public static int findRandomNum1(int[] arr){
        if (arr == null || arr.length < 2){
            return -1;
        }
        for (int i : arr){
            if (i < 1 || i > arr.length - 1){
                return  -1;
            }
        }

        int [] arrTemp = new int[arr.length];
        for (int i : arr){
            if (arrTemp [i] == i){
                return i;
            }
            arrTemp [i] = i;
        }
        return -1;
    }

    public static int findRandomNum2(int[] arr){
        if (arr == null || arr.length < 2){
            return -1;
        }
        for (int i : arr){
            if (i < 1 || i > arr.length - 1){
                return  -1;
            }
        }

        int low = 1;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int count = countRange(arr, low, mid); // 计算数组中 low ~ mid 之间数字的个数

            if (low == high){
                if (count > 1){ // 如果数组中这个数字的个数大于 1
                    return low;
                }else {
                    return -1;
                }
            }

            if (count > (mid -low + 1)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 计算 arr 数组中 low 和 high 之间数字的个数
    public static int countRange(int[] arr,int low, int high){
        int sum = 0;
        for (int i : arr){
            if (i >= low && i <= high){
                sum ++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(findRandomNum2(arr));
        System.out.println();
        System.out.println(findRandomNum1(arr));

    }

}
