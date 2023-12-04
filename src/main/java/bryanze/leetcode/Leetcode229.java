package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * @author lizelin
 */

public class Leetcode229 {
    public List<Integer> majorityElement(int[] nums) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length / 3) {
                list.add(entry.getKey());
            }

        }

        return list;
    }

    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0, j; i < nums.length; i = j + 1) {
            j = i;
            while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                j++;
            }

            if (j - i + 1 > nums.length / 3) {
                list.add(nums[i]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Leetcode229().majorityElement1(nums));
    }
}
