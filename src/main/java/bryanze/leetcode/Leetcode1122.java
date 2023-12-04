package bryanze.leetcode;

/**
 * 给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * @author lizelin
 * @date 2023/11/29
 */
public class Leetcode1122 {

    /*
    计数排序
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];

        for (int i : arr1) {
            count[i]++;
        }

//        int[] result = new int[arr1.length];

        int k = 0;
        for (int v : arr2) {

            while(count[v] > 0){
                arr1[k++] = v;
                count[v]--;
            }
        }

        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0){
                arr1[k++] = i;
                count[i]--;
            }

        }

        return arr1;
    }

}
