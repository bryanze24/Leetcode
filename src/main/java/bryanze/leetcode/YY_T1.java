package bryanze.leetcode;

import java.util.Map;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/06
 */
public class YY_T1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] split = str.split(" ");
//        int[] nums = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            nums[i] = Integer.parseInt(split[i]);
//        }
//
//        int power = nums[0];
//        if (power == 0) {
//            System.out.println(false);
//            return;
//        }
//        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (dp[j] && (i - j) <= nums[j]) {
//                    dp[i] = true;
//                    break;
//                }
//
//            }
//        }
//
//        System.out.println(dp[nums.length -  1] && nums[nums.length - 1] != 0);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        boolean res = dfs(nums);
        System.out.println(res);

    }

    private static boolean dfs(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= n - 1){
                return true;
            }

        }

        return  maxReach >= n - 1;
    }
}
