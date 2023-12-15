package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer,
 * 子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * @author lizelin
 * @date 2023/12/15
 */
public class Leetcode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxValue = nums[0];

        //第一步:动态规划找出最大子集的个数，最大子集中的最大整数
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }

        //第二步:倒推获得最大子集
        List<Integer> list = new ArrayList<>();

        if (maxSize == 1) {
            list.add(nums[0]);
            return list;
        }

        for (int i = length - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                list.add(nums[i]);
                maxSize--;
                maxValue = nums[i];
            }
        }

        return list;
    }

    public List<Integer> largestDivisibleSubset1(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);

        int[] f = new int[length];
        int[] g = new int[length];

        for (int i = 0; i < length; i++) {
            //至少包含自身一个数，因此起始长度为1，由自身转移而来
            int prev = i;
            int len = 1;

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0) {

                    //如果能接在更长的序列后面，则更新 [最大长度] 和 [从何转移而来]
                    if (f[j] + 1 > len) {
                        prev = j;
                        len = f[j] + 1;

                    }
                }
            }

            //记录 [最终长度] & [从何转移而来]
            f[i] = len;
            g[i] = prev;
        }

        //遍历所有的 f[i],取得 [最大长度] & [对应下标]
        int maxSize = -1, id = -1;
        for (int i = 0; i < length; i++) {
            if (f[i] > maxSize) {
                maxSize = f[i];
                id = i;
            }
        }

        List<Integer> list = new ArrayList<>();

        //使用 g[] 数组回溯出具体方案
        while (list.size() != maxSize) {
            list.add(nums[id]);
            id = g[id];
        }

        return list;
    }

    public static void main(String[] args) {
        int[] nums = {9, 18, 54, 90, 108, 180, 360, 540, 720};
        List<Integer> list = new Leetcode368().largestDivisibleSubset1(nums);
        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
    }
}
