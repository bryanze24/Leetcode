package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author lizelin
 * @date 2024/03/29
 */
public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {

            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = length - 1;

            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp > 0) {
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;
                } else if (temp < 0) {
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                } else {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[k]);
                    ans.add(path);
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    k--;

                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                }
            }

        }

        return ans;
    }
}
