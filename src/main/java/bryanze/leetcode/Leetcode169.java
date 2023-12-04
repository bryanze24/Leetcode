package bryanze.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */

public class Leetcode169 {
    public int majorityElement(int[] nums) {
        int length =  nums.length;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(entry.getValue() > length / 2){
                return entry.getKey();
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(new Leetcode169().majorityElement(nums));
    }
}
