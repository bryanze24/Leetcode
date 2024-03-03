package bryanze.leetcode;


/**
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 *
 * @author lizelin
 * @date 2024/03/03
 */
public class Leetcode718 {
    public int findLengthByDp1(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        // dp[i][j]表示以nums1[i - 1] 和nums2[j - 1]结尾的最长重复子数组的长度
        int[][] dp = new int[l1 + 1][l2 + 1];

        int ans = 0;
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {

                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }

            }

        }

        return ans;
    }

    public int findLengthByDp2(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[][] dp = new int[l1][l2];
        int ans = 0;

        /*
        初始化dp数组
         */
        for (int i = 0; i < l1; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
                ans = 1;
            }
        }

        for (int i = 0; i < l2; i++) {
            if (nums2[i] == nums1[0]) {
                dp[0][i] = 1;
                ans = 1;
            }
        }


        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {

                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                ans = Math.max(ans, dp[i][j]);

            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 2, 1};
        int[] nums2 = new int[]{3, 2, 1, 4};
        System.out.println(new Leetcode718().findLengthByDp1(nums1, nums2));

    }
}
