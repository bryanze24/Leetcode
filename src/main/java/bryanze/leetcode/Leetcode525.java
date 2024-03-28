package bryanze.leetcode;

import java.util.HashMap;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * @author lizelin
 * @date 2024/03/28
 */
public class Leetcode525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cur = 0, ans = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            cur = nums[i] == 0 ? cur - 1 : cur + 1;
            if (map.containsKey(cur)) {
                ans = Math.max(ans,  i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }

        return ans;
    }

    public int findMaxLength1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                count++;
            } else {
                count--;
            }

            if (map.containsKey(count)) {
                ans = Math.max(ans, i - map.get(count));
            } else {
                map.put(count, i);
            }

        }

        return ans;
    }

}
