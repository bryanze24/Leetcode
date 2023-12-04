package bryanze.algorithm.recursion;

import java.util.Arrays;

/**
 * 递归冒泡排序
 *     将数组划分成两部分 [0 .. j] [j+1 .. a.length-1]
 *     左边 [0 .. j] 是未排序部分
 *     右边 [j+1 .. a.length-1] 是已排序部分
 *     未排序区间内, 相邻的两个元素比较, 如果前一个大于后一个, 则交换位置
 */
public class E04BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    /**
     * 递归函数 在范围 [0 .. j] 内冒泡最大元素到右侧
     * @param a 数组
     * @param j 未排序区域右边界
     */
    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0; //x及x左侧是未排序的, x右侧是已经排好序的
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }

        bubble(a, x);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        bubble(a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

}
