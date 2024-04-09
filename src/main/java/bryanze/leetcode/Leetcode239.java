package bryanze.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * @author lizelin
 * @date 2024/04/09
 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1]);

        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = queue.peek()[0];

        for (int i = k; i < nums.length; i++) {

            while (!queue.isEmpty() && queue.peek()[1] <= i - k) {
                queue.poll();
            }

            queue.offer(new int[]{nums[i], i});
            ans[i - k + 1] = queue.peek()[0];

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        int[] ans = new Leetcode239().maxSlidingWindow(nums, 5);
        System.out.println(Arrays.toString(ans));
    }
}
