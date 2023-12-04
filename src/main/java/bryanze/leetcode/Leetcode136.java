package bryanze.leetcode;

import java.util.HashSet;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * @author lizelin
 * @date 2023/11/26
 */

public class Leetcode136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (Integer num : nums) {
            result ^= num;
        }

        return result;
    }

    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {

            if(!set.add(num)){
                set.remove(num);
            }
        }

        return set.toArray(new Integer[0])[0];
    }
}
