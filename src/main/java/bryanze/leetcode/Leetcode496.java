package bryanze.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素
 *
 * @author lizelin
 * @date 2023/11/21
 */

public class Leetcode496 {
    /**
     这个问题可以这样抽象思考：把数组的元素想象成并列站立的人，元素大小想象成人的身高。
     这些人面对你站成一列，如何求元素「2」的 Next Greater Number呢？
     很简单，如果能够看到元素「2」，那么他后面可见的第一个人就是「2」的 Next Greater Number，
     因为比「2」小的元素身高不够，都被「2」挡住了，第一个
     露出来的就是答案。
     --------
     |      -------
     --------------------|      |
     |       -------|    |      |
     |       |      |    |      |
     2       1      2    4      3
     4       2      4    -1     -1
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = nextGreaterHelper(nums2);

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    private Map<Integer, Integer> nextGreaterHelper(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();  // 存放高个元素的栈
        for (int i = nums.length - 1; i >= 0; i--) {  // 倒着往栈里放
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();  // 矮个起开，反正也被挡着了
            }

            map.put(nums[i], stack.isEmpty() ? -1 : stack.peek());  // 当前元素身后的第一个高个
            stack.push(nums[i]);  // 进队，接受之后的身高判定

        }
        return map;

    }
}