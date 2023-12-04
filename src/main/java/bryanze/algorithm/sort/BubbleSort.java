package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author lizelin
 * @date 2023/11/26
 */
public class BubbleSort {

    private static void bubble(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    count++;
                }
            }

            if (count == 0) { //如果某一趟没有发生交换，则说明顺序已排好
                break;
            }

        }
    }

    private static void bubble1(int[] array) {
        int j = array.length - 1;

        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    x = i;
                }
            }
            j = x;

        } while (j != 0);
    }

    private static void bubbleSort(int[] array) {
        int n = array.length;
        boolean flag;

        do {
            flag = false;
            int x = 0;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    // 交换相邻元素
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    x = i;
                    flag = true;
                }
            }
            n= x;
        } while (flag);
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
