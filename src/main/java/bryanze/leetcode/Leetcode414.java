package bryanze.leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。
 * 如果不存在，则返回数组中最大的数。
 *
 * @author lizelin
 * @date 2023/12/04
 */
public class Leetcode414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;
        int max = nums[length - 1];
        int k = 1;

        int index = nums.length - 2;

        while (index >= 0) {

            if (nums[index] != nums[index + 1]) {
                k++;
            }

            if (k == 3) {
                return nums[index];
            }
            index--;
        }

        return max;
    }

    public int thirdMax1(int[] nums) {

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }

        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new Leetcode414().thirdMax1(nums));
    }
}
