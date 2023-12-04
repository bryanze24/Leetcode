package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */

public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sort = new int[m + n];
        int k = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                sort[k] = nums1[p1];
                p1++;
            } else {
                sort[k] = nums2[p2];
                p2++;
            }
            k++;
        }

        if (p1 == m) {
            System.arraycopy(nums2, p2, sort, k, n - p2);
        }

        if (p2 == n) {
            System.arraycopy(nums1, p1, sort, k, m - p1);
        }

        System.arraycopy(sort, 0, nums1, 0, sort.length);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new Leetcode88().merge(nums1, 3,nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
