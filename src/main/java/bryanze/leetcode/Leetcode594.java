package bryanze.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 * @author lizelin
 * @date 2023/12/18
 */
public class Leetcode594 {

    //双指针 + 剪枝
    public int findLHS(int[] nums) {

        Arrays.sort(nums);
        int count = 0;
        int frequence;

        for (int i = 0; i < nums.length - 1; i = i + 1 + frequence) {

            boolean flag = false; //标记是否有相差为 1 的元素
            int j = i + 1;
            frequence = 0; // 标记重复的元素个数

            for (; j < nums.length; j++) {

                if (nums[j] != nums[i]) {

                    if (nums[j] - nums[i] == 1) {
                        flag = true; //更改标记

                    } else {
                        break;
                    }

                } else { //说明nums[i]与nums[j]相等，即nums[i]有重复，循环中nums[i]遍历一次即可，其他跳过
                    frequence++;
                }
            }

            if (flag) {
                //此时 j 与 i 之间的都是相差为 1 的元素
                count = Math.max(count, j - i);
            }

        }

        return count;
    }

    //hash
    public int findLHS1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer integer : map.keySet()) {
            if(map.containsKey(integer + 1)){
                count = Math.max(count, map.get(integer) + map.get(integer + 1));
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(new Leetcode594().findLHS1(nums));

    }
}
