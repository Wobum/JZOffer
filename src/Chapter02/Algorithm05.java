package Chapter02;

public class Algorithm05 {
/**
 * @Auther: Wobum
 * @Date: 2018/12/1 21:15
 * @Description: 两个有序数组 A1 和 A2，A1 数组后有足够的空间存储 A2,要去合并 A1，A2，使得合并后的数组有序
 */

    /*
        @param: i -> arr1 数组中存储了多少个数
     */
    public static int[] mergeArr(int[] arr1, int[] arr2, int i){
        if (arr1 == null || arr2 == null){
            return null;
        }

        int p1 = i - 1;
        int p2 = arr2.length -1;
        int p3 = i + arr2.length -1;

        // 先让遍历完 arr1 数组或者 arr2 数组
        while (p2 >= 0 && p1 >= 0){
            if (arr2[p2] > arr1[p1]){
                arr1[p3]  = arr2[p2];
                p2--;
            }else {
                arr1[p3] = arr1[p1];
                p1--;
            }
            p3--;
        }

        // arr2 数组没有遍历完
        while (p2 >= 0){
            arr1[p3--] = arr2[p2--];
        }

        return arr1;
    }

    public static void printArr(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = {0,0,0,0};
        printArr(arr2);

        arr1[0] = 1;
        arr1[1] = 5;
        arr1[2] = 7;
        arr1[3] = 9;
        arr1[4] = 11;

        printArr(arr1);
        mergeArr(arr1, arr2, 5);
        printArr(arr1);
    }
}
