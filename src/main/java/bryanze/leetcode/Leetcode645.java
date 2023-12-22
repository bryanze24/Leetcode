package bryanze.leetcode;

import java.util.Arrays;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了
 * 成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * @author lizelin
 * @date 2023/12/22
 */
public class Leetcode645 {

    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (i + 1);
        }

        int numsSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                result[0] = nums[i];
            }
            numsSum += nums[i];
        }
        numsSum += nums[nums.length - 1];

        result[1] = result[0] - (numsSum - sum);

        return result;
    }

    public int[] findErrorNums1(int[] nums) {
        int[] array = new int[nums.length + 1];
        int[] result = new int[2];

        for (int num : nums) {
            array[num]++;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 2) {
                result[0] = i;
            } else if (array[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};
        System.out.println(Arrays.toString(new Leetcode645().findErrorNums(nums)));
    }

}
