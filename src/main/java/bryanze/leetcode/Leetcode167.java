package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给你一个下标从 1 开始的整数数组 numbers,该数组已按非递减顺序排列,
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2],
 * 则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 */

public class Leetcode167 {

    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] < target) {
                    continue;
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }

        }
        return null;
    }

    //1ms
    public int[] twoSum(int[] numbers, int target) {
        int slow = 0;
        int fast = numbers.length - 1;
        while (slow < fast) {
            if (numbers[slow] + numbers[fast] == target) {
                return new int[]{slow + 1, fast + 1};
            } else if (numbers[slow] + numbers[fast] < target) {
                slow++;
            } else {
                fast--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 11, 12};
        System.out.println(Arrays.toString(new Leetcode167().twoSum(array, 23)));
    }
}
