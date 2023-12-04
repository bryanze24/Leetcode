package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序(自下而上)
 *
 * @author lizelin
 * @date 2023/11/28
 */
public class MergeSortBottomUp {

    public static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    public static void sort(int[] array) {

        int length = array.length;
        int[] tempArray = new int[length];

        // width 代表有序区间的宽度，取值一次为1,2,4
        for (int width = 1; width < length; width *= 2) {

            // [left, right] 分别代表待合并区间的左右边界
            for (int left = 0; left < length; left += 2 * width) {
                int right = Math.min(left + 2 * width - 1, length - 1);
                int mid = Math.min(left + width - 1, length - 1);
                merge(array, left, mid, mid + 1, right, tempArray);

//                System.out.printf("width %d [%d, %d]\n", width, left, right);
            }

            System.arraycopy(tempArray, 0, array, 0, length);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
