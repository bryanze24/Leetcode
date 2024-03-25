package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @author lizelin
 * @date 2024/03/25
 */
public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        int[] priMul = new int[length];
        priMul[0] = 1;
        int[] aftMul = new int[length];
        aftMul[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            priMul[i] = priMul[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            aftMul[i] = aftMul[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = priMul[i] * aftMul[i];
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(new Leetcode238().productExceptSelf(nums)));
    }
}
