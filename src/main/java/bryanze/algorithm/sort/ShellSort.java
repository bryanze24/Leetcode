package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author lizelin
 * @date 2023/11/27
 */
public class ShellSort {

    public static void sort(int[] array) {
        for (int gap = array.length >> 1; gap >= 1; gap = gap >> 1) {

            for (int low = gap; low < array.length; low++) {

                int temp = array[low];
                int i = low - gap;

                while (i >= 0 && temp < array[i]) {
                    array[i + gap] = array[i];
                    i -= gap;
                }

                //找到插入位置
                if (i != low - gap) {
                    array[i + gap] = temp;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
