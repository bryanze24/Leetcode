package bryanze.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/08/26
 */
public class T1_4399 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = str.lastIndexOf(",");

        String price = str.substring(0, index);
        String tar = str.substring(index + 1);
        String substring = price.substring(9, price.length() - 1);
        String[] strArray = substring.split(", ");
        int[] nums = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            nums[i] = Integer.parseInt(strArray[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = tar.length() - 1; i >= 0; i--) {
            if (tar.charAt(i) == ' ') {
                break;
            }
            sb.append(tar.charAt(i));
        }

        int target = Integer.parseInt(sb.reverse().toString());

        int[] res = twosum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twosum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])) {
                res[0] = nums[i];
                res[1] = target - nums[i];
                break;
            }
        }
        return res;
    }
}
