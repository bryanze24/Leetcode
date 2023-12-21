package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * @author lizelin
 * @date 2023/12/21
 */
public class Leetcode632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int length = 0;
        for (List<Integer> list : nums) {
            length += list.size();
        }
        int[][] array = new int[length][2];

        int i = 0;
        int j = 0;
        for (List<Integer> list : nums) {
            for (Integer integer : list) {
                array[i][0] = integer;
                array[i][1] = j;
                i++;
            }
            j++;
        }

        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));
//        System.out.println(Arrays.deepToString(array));

        int[] ans = new int[2];
        int[] count = new int[nums.size()];

        int k = 0;
        int l = 0;

        for (int r = 0; r < length; r++) {
            if (count[array[r][1]]++ == 0) {
                k++;
            }

            if (nums.size() == k) {
                while (count[array[l][1]] > 1) {
                    count[array[l][1]]--;
                    l++;
                }

                if ((ans[0] == 0 && ans[1] == 0) || ans[1] - ans[0] > array[r][0] - array[l][0]) {
                    ans = new int[]{array[l][0], array[r][0]};
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));
        System.out.println(Arrays.toString(new Leetcode632().smallestRange(nums)));
    }

}
