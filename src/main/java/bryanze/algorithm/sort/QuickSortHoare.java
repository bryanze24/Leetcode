package bryanze.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 快速排序，双边循环
 * 选择最左元素作为基准点元素
 * j 指针负责从右向左找比基准点小或等的元素，i 指针负责从左向右找比基准点大的元素，
 * 一旦找到二者交换，直至 i，j 相交
 * 最后基准点与 i（此时 i 与 j 相等）交换，i 即为分区位置
 * @author lizelin
 * @date 2023/11/28
 */
public class QuickSortHoare {

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

    /*
        注意事项
        1. 为啥要加内层循环的 i < j 条件
        2. 为啥要先处理 j，再处理 i
        3. 随机元素作为基准点
        4. 如果有大量重复元素
     */

    private static int partition(int[] array, int left, int right) {

        //把随机元素作为基准点
        int id = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        //与最左侧元素交换位置
        swap(array, id, left);

        int pv = array[left]; // 代表基准点元素的值
        int i = left;
        int j = right;

        while (i < j) {

            //1.从右向左找小的
            while (i < j && array[j] > pv) {
                j--;
            }

            //2.从左向右找大的
            while (i < j && array[i] <= pv) {
                i++;
            }

            //3.交换位置
            swap(array, i, j);
        }

        swap(array, left, i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
