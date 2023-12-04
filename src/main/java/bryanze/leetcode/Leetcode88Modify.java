package bryanze.leetcode;


/**
 * 合并两个有序数组
 */
public class Leetcode88Modify {

    public void merge(int[] nums1, int i, int iEnd, int j, int jEnd, int[] nums2) {
        int k = 0;
        while (i <= iEnd && j <= jEnd) {
            if (nums1[i] < nums1[j]) {
                nums2[k] = nums1[i];
                i++;
            } else {
                nums2[k] = nums1[j];
                j++;
            }
            k++;
        }

        if (i > iEnd) {
            System.arraycopy(nums1, j, nums2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(nums1, i, nums2, k, iEnd - i + 1);
        }
    }
}
