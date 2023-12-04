package bryanze.algorithm.sort;


import java.util.Arrays;

/**
 * 归并排序(自上而下)
 * @author lizelin
 * @date 2023/11/27
 */
public class MergeSortUpBottom {

    /*
            a1 原始数组
            i~iEnd 第一个有序范围
            j~jEnd 第二个有序范围
            a2 临时数组
    */
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

    private static void sort(int[] array) {
        int[] tempArray = new int[array.length];
        split(array, 0, array.length - 1, tempArray);
    }

    private static void split(int[] array, int left, int right, int[] tempArray) {

        //2.治
        if (left == right) {
            return;
        }

        //1.分
        int mid = (left + right) >>> 1;
        split(array, left, mid, tempArray);
        split(array, mid + 1, right, tempArray);

        //3.合
        merge(array, left, mid, mid + 1, right, tempArray);
        System.arraycopy(tempArray, left, array, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
