package bryanze.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k，请你在数组中找出 不同的 k-diff 数对，
 * 并返回不同的 k-diff 数对 的数目。
 * k-diff 数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * @author lizelin
 * @date 2023/12/17
 */
public class Leetcode532 {
    public int findPairs(int[] nums, int k) {

        Arrays.sort(nums);
        int count = 0, j;
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {

            j = i + 1;

            while (j < length) {

                if (nums[j] - nums[i] > k) {
                    break;
                } else if (nums[j] - nums[i] == k) {
                    count++;
                    //因为与一个数的差值为k的数只有一个，即使后面还有符合条件的也是重复
                    break;
                } else {
                    j++;
                }

            }

            //当nums[i]与nums[i+1]相等时，就过滤掉，因为nums[i]已经筛选完符合条件的了
            while (i + 1 < length && nums[i] == nums[i + 1]) {
                i++;
            }

        }

        return count;
    }

    public int findPairs1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {

            if (map.get(num) == 0) {
                continue;
            }

            if (k == 0) {
                if (map.get(num) > 1) {
                    count++;
                }
            } else {
                int a = num - k, b = num + k;
                if (map.getOrDefault(a, 0) > 0) {
                    count++;
                }

                if (map.getOrDefault(b, 0) > 0) {
                    count++;
                }
            }


            map.put(num, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2};
        System.out.println(new Leetcode532().findPairs(nums, 1));
    }
}
