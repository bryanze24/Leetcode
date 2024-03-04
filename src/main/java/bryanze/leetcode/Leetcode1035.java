package bryanze.leetcode;

/**
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * @author lizelin
 * @date 2024/03/04
 */
public class Leetcode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {

                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 2, 1, 5, 2};
        System.out.println(new Leetcode1035().maxUncrossedLines(nums1, nums2));
    }

}
