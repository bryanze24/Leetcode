package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序的步骤
 * 1.从第一个元素开始，认为第一个元素是已排序的。
 * 2.取出下一个元素，在已排序的序列中从后向前扫描。
 * 3.如果已排序的元素大于新元素，将已排序的元素向后移动一位。
 * 4.重复步骤 3，直到找到已排序元素小于或等于新元素的位置。
 * 5.将新元素插入到该位置。
 * 重复步骤 2-5，直到所有元素都被处理完。
 *
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
//        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0};
        int[] array = {0, 3, 6, 5, 7, 9, 2, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
