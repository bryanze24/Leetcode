package bryanze.leetcode;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */

public class Leetcode283 {
    //2ms
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
                fast++;
            } else if (nums[slow] == 0 && nums[fast] == 0) {
                fast++;
            } else {
                slow++;
                fast++;
            }
        }
    }

    //1ms
    public void moveZeroes1(int[] nums){
        if(nums.length == 1){
            return;
        }
        int j = 0;
        //把数组中非零元素向前移动，并且一共有j + 1个非零元素
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        //将数组中的后面的空位补0
        for(; j < nums.length; j++){
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {0,2,0,3,1,2};
        new Leetcode283().moveZeroes1(array);
        System.out.println(Arrays.toString(array));
    }
}
