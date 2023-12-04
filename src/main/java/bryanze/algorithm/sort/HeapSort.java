package bryanze.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author lizelin
 * @date 2023/11/27
 */
public class HeapSort {

    public static void heapSort(int[] array){
        heapify(array, array.length);

        for (int right = array.length - 1; right > 0  ; right--) {
            swap(array, 0 ,right);
            down(array, 0, right);
        }
    }

    private static void heapify(int[] array, int size){
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(array, i, size);
        }
    }


    private static void down(int[] array, int parent, int size) {

        while (true) {

            int left = 2 * parent + 1;
            int right = left + 1;
            int max = parent;

            if (left < size && array[left] > array[max]) {
                max = left;
            }

            if(right < size && array[right] > array[max]){
                max = right;
            }

            if(max == parent){
                break;
            }

            swap(array, max, parent);
            parent = max;

        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {0, 3, 6, 3, 6, 7, 8, 2, 5, 7, 9, 2, 1, 0};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

}
