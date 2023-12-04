package bryanze.leetcode;


/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，
 * 使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */

public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        int count = 1;
        int length = nums.length;
        while (p2 < nums.length) {
            if (nums[p1] == nums[p2] && count >= 2) {
                count++;
                length--;
                p2++;
            } else if (nums[p1] == nums[p2]) {
                nums[p1 + 1] = nums[p2];
                p1++;
                p2++;
                count++;
            } else {
                nums[p1 + 1] = nums[p2];
                p1++;
                p2++;
                count = 1;
            }
        }
        return length;
    }

    public int removeDuplicates1(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int result = 1;
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                times++;
                if (times <= 2) {
                    nums[result++] = nums[i];
                }
            } else {
                times = 1;
                nums[result++] = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = new Leetcode80().removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
