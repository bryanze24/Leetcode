package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。
 * 输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */

public class Leetcode349 {

    //5ms
    public int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums2);

        HashSet<Integer> set = new HashSet<>();
        for (int j : nums1) {
            set.add(j);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (i == 0) {
                if (set.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
            } else if (nums2[i] == nums2[i - 1]) {
                continue;
            } else {
                if (set.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
            }

        }
        int[] array = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            array[k] = list.get(k);
        }

        return Arrays.stream(array).toArray();

    }

    //2ms
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                if(index == 0 || nums1[p1] != result[index - 1]){
                    result[index] = nums1[p1];
                    index++;
                }
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] result = new Leetcode349().intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }
}
