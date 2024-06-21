package bryanze.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组
 * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 *
 * @author lizelin
 * @date 2024/06/20
 */
public class Leetcode152 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;

        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }

        return max;
    }

}
