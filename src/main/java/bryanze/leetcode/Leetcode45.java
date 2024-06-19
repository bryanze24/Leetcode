package bryanze.leetcode;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，
 * 如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]，i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。
 * 生成的测试用例可以到达 nums[n - 1]。
 *
 * @author lizelin
 * @date 2024/06/19
 */
public class Leetcode45 {
    public int jump(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
            start = end;
            end = maxPos + 1;
            ans++;
        }

        return ans;
    }
}
