package bryanze.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j]组成且满足 0 <= i < j < nums.length 。
 * 返回 所有数对距离中 第 k 小的数对距离
 *
 * @author lizelin
 * @date 2023/12/26
 */
public class Leetcode719 {
    /*
    超出内存限制
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            while (j < nums.length) {

                int distance = nums[j] - nums[i];

                if (queue.isEmpty() || queue.size() <= k) {
                    queue.offer(distance);

                    if (queue.size() > k) {
                        queue.poll();
                    }

                    if (distance > queue.peek()) {
                        break;
                    }

                }

                j++;
            }
        }

        return queue.peek();
    }

    public int smallestDistancePair1(int[] nums, int k) {
        Arrays.sort(nums);

        int length = nums.length;
        int left = 0;
        int right = nums[length - 1] - nums[0];

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            int count = countLessEquals(nums, mid);

            if (count < k) {
                // 如果小于等于 mid 的个数严格小于 k 个，说明 mid 太小了
                // 下一轮搜索区间为 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间为 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 统计距离（数值之差的绝对值）小于等于 threshold 的个数
     *
     * @param nums      数组
     * @param threshold 阈值
     * @return 返回个数
     */
    private int countLessEquals(int[] nums, int threshold) {
        int count = 0;
        int length = nums.length;

        for (int left = 0, right = 0; right < length; right++) {

            while (nums[right] - nums[left] > threshold) {
                left++;
            }

            // 此时满足 nums[right] - nums[left] <= threshold
            // right 与 [left..right - 1] 里的每一个元素的「距离」都小于等于 threshold
            // [left..right - 1] 里元素的个数为 right - left
            count += right - left;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {38, 33, 57, 65, 13, 2, 86, 75, 4, 56};
        System.out.println(new Leetcode719().smallestDistancePair1(nums, 26));
    }
}
