package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * @author lizelin
 */

public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        int length = nums.length;
        while (i < length) {
            int low = i;
            i++;

            while (i < length && nums[i] == nums[i - 1] + 1) {
                i++;
            }

            int high = i - 1;
            StringBuilder str = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                str.append("->");
                str.append(Integer.toString(nums[high]));
            }

            list.add(str.toString());
        }

        return list;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> list = new ArrayList<>();
        int length = nums.length;
        for (int i = 0, j; i < length; i = j + 1) {
            j = i;
            while (j + 1 < length && nums[j + 1] == nums[j] + 1){
                j++;
            }

            list.add(str(nums, i ,j));
        }
        return list;
    }

    private String str(int[] nums, int i, int j){
        return i == j ? nums[j] + "" : String.format("%d->%d", nums[i], nums[j]);

    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(new Leetcode228().summaryRanges(nums));
    }
}
