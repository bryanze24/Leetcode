package bryanze.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lizelin
 * @date 2023/11/29
 */
public class QuickSortHandleDuplicate {

    public static void sort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(a, left, right);
        quick(a, left, p - 1);
        quick(a, p + 1, right);

    }

    /*
        循环内
            i 从 left + 1 开始，从左向右找大的或相等的
            j 从 right 开始，从右向左找小的或相等的
            交换，i++ j--

        循环外 j 和 基准点交换，j 即为分区位置
     */
    private static int partition(int[] a, int left, int right) {
        int idx = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a, left, idx);
        int pv = a[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {

            // i 从左向右找大的或者相等的
            while (i <= j && a[i] < pv) {
                i++;
            }

            // j 从右向左找小的或者相等的
            while (i <= j && a[j] > pv) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }

        }
        swap(a, j, left);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
