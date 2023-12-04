package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 * @author lizelin
 * @date 2023/11/29
 */
public class CountingSort {

    public static void sort(int[] array) {
        int max = array[0];
        int min = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] > max) {
                max = array[i];
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        int[] count = new int[max - min + 1];

        for (int value : array) {
            count[value - min]++;

        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0) {
                array[k++] = i + min;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, -9, -3, 8, 2, 5, 7, 9, 2, -10, 1, 0, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
