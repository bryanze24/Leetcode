package bryanze.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
 *
 * @author lizelin
 * @date 2024/03/26
 */
public class Leetcode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;

        for (int i = 0; i < length; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Leetcode523().checkSubarraySum(nums, 5));
    }

}
