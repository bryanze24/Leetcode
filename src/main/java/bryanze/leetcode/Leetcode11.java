package bryanze.leetcode;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，
 * 第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * @author lizelin
 * @date 2024/09/21
 */
public class Leetcode11 {
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                int h = Math.min(height[i], height[j]);
                int area = h * (j - i);
                res = Math.max(res, area);
                if (height[i] <= h) {
                    break;
                }
            }
        }
        return res;
    }
}
