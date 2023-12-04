package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 *
 * @author lizelin
 * @date 2023/11/29
 */
public class Leetcode1636 {

    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> cnt = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        list.sort((a, b) -> {
            int af = cnt.get(a);
            int bf = cnt.get(b);
            return af != bf ? af - bf : b - a;
        });

//        Collections.sort(list, (a, b) -> {
//            int af = cnt.get(a);
//            int bf = cnt.get(b);
//            return af != bf ? af -bf : b - a;
//        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 3};
        int[] frequencySort = new Leetcode1636().frequencySort(nums);

        for (int num : frequencySort) {
            System.out.println(num);
        }

    }
}
