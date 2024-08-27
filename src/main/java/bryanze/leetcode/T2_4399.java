package bryanze.leetcode;

import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/08/26
 */
public class T2_4399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String str = string.substring(8, string.length() - 1);
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                count++;
            }
        }

        return count <= 1;
    }
}
