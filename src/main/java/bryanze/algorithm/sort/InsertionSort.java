package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author lizelin
 * @date 2023/11/27
 */
public class InsertionSort {

    public static void sort(int[] array) {
        for (int low = 1; low < array.length; low++) {
            int temp = array[low];
            int i = low - 1;

            while (i >= 0 && temp < array[i]) {
                array[i + 1] = array[i];
                i--;
            }

            //找到插入位置
            if (i != low - 1) {
                array[i + 1] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
