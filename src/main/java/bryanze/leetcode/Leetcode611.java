package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 *
 * @author lizelin
 * @date 2023/12/19
 */
public class Leetcode611 {

    /*
    垃圾代码
     */
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        return count;
    }


    public int triangleNumber1(int[] nums) {

        Arrays.sort(nums); // 升序排列
        int length = nums.length - 1;
        int count = 0;

        while (length > 1) { //固定第三条边 nums[length]

            int left = 0;
            int right = length - 1;

            while (left < right) { //双指针遍历数组

                if (nums[left] + nums[right] > nums[length]) {
                    count += right - left; //满足条件时，则证明left至right之间的元素均满足条件
                    right--; // 更换第二条边，减小nums[right],通过right左移实现

                } else { // 条件未满足时，更换第一条边，增大nums[left]，使用left右移实现
                    left++;
                }

            }

            length--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 4};
        System.out.println(new Leetcode611().triangleNumber1(nums));
    }
}
