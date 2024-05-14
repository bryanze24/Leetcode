package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 单边循环快排(lomuto 洛穆托分区方案)
 * 核心思想：每轮找到一个基准点元素，把比它小的放到它左边，比它大的放到它右边，这称为分区
 * 选择最右元素作为基准点元素
 * 找比基准点小的，i 找比基准点大的，一旦找到，二者进行交换
 * 交换时机：j 找到小的，且与 i 不相等
 * i 找到 >= 基准点元素后，不应自增
 * 最后基准点与 i 交换，i 即为基准点最终索引
 *
 * @author lizelin
 * @date 2023/11/28
 */
public class QuickSortLomuto {

    public static void sort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right); // p代表基准点元素索引
        quick(array, left, p - 1);
        quick(array, p + 1, right);

    }

    private static int partition(int[] array, int left, int right) {
        int pv = array[right]; // 代表基准点元素的值
        int i = left;
        int j = left;

        while (j < right) {
            if (array[j] <= pv) {
                if (i != j) {
                    swap(array, i, j);
                }
                i++;
            }

            j++;
        }

        swap(array, i, right);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 10, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0, 10};
//        int[] array = {3, 6, 8, 10, 1, 2, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
