package bryanze.leetcode;


/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */

public class Leetcode75 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (nums[i] == 2 && i <= p2) {
                swap(nums, i, p2);
                p2--;
            }
            if (nums[i] == 0){
                swap(nums, i , p0);
                p0++;
            }
        }
    }

    public void sortColors1(int[] nums){
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                swap(nums, i, ptr);
                ptr++;
            }
        }

        for (int i = ptr; i < nums.length; i++) {
            if(nums[i] == 1){
                swap(nums, i, ptr);
                ptr++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
