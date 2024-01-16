package bryanze.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * 请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * @author lizelin
 * @date 2024/01/16
 */
public class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] preNum = new int[length + 1];

        preNum[0] = 0;
        for (int i = 0; i < length; i++) {
            preNum[i + 1] = preNum[i] + nums[i];
        }

        int count = 0;

        for (int left = 0; left < length; left++) {
            for (int right = left; right < length; right++) {

                if (preNum[right + 1] - preNum[left] == k) {
                    count++;
                }

            }
        }

        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int preSum = 0;

        for (int num : nums) {
            preSum += num;

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }

        return count;
    }
}
