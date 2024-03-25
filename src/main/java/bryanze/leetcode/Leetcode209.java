package bryanze.leetcode;


/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
 * 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @author lizelin
 * @date 2024/03/25
 */
public class Leetcode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int[] prifix = new int[length + 1];
        for (int i = 0; i < length; i++) {
            prifix[i + 1] = prifix[i] + nums[i];
        }

        if (prifix[length] < target) {
            return 0;
        }


        int i = 0;
        while (i < length + 1 && prifix[i] < target) {
            i++;
        }
        int ans = i;
        for (; i < length + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (prifix[i] - prifix[j] >= target) {
                    ans = Math.min(ans, i - j);
                } else {
                    break;
                }
            }
        }

        return ans;
    }


    public int minSubArrayLenSlideTheWindow(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(new Leetcode209().minSubArrayLen(7, nums));
        System.out.println(new Leetcode209().minSubArrayLenSlideTheWindow(7, nums));
    }
}
