package Chapter02;

import java.util.Random;

public class BubbleSort {
    /**
     * @Auther: Wobum
     * @Date: 2018/12/4 18:12
     * @Description: 各种排序函数
     */
    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true; // 每一轮开始都是 true
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 有元素交换，所以不是有序的，
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void bubbleSort3(int[] arr){
        if (arr == null || arr.length == 1) {
            return;
        }
        int lastExchangeIndex = 0; // 记录最后一次的交换位置
        int sortBorder = arr.length - 1; //无序数列的边界，每次比较只要比到这里即可
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true; // 每一轮开始都是 true
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    // 有元素交换，所以不是有序的，
                    flag = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (flag) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generationArr() {
        int[] arr = new int[10000];
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(10000);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr1 = generationArr();
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        long starttime = System.currentTimeMillis();
        bubbleSort1(arr1);
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + "ms");

        starttime = System.currentTimeMillis();
        bubbleSort2(arr2);
        endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + "ms");

        starttime = System.currentTimeMillis();
        bubbleSort3(arr3);
        endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime + "ms");

        for (int i : arr1) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : arr3) {
            System.out.print(i + " ");
        }

    }
}
