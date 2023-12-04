package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author lizelin
 * @date 2023/11/27
 */
public class SelectionSort {

    public static void sort(int[] array){
        //1.选择轮数，数组长度 - 1
        //2.交换的索引位置(right) 初始 array.length - 1,每次递减
        for (int right = array.length - 1; right > 0 ; right--) {

            int max = right;
            for (int i = 0; i < right; i++) {
                if(array[i] > array[max]){
                    max = i;
                }
            }
            //减少不必要的交换
            if(max != right){
                swap(array, max, right);
            }

        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
