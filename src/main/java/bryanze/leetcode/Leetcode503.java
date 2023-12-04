package bryanze.leetcode;

import java.util.*;

/**
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），
 * 返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * @author lizelin
 * @date 2023/11/21
 */
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <nums[i % nums.length]){
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }

        return result;
    }

    public int[] nextGreaterElements1(int[] nums){
        int[] result = new int[nums.length];
        Map<Integer, Integer> map = nextGreaterHelper(nums);

        for (int i = 0; i < nums.length; i++) {
            result[i] = map.get(i);
        }

        return result;
    }

    private Map<Integer, Integer> nextGreaterHelper(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();  // 存放高个元素的栈
        for (int i = 2 * length - 1; i >= 0; i--) {  // 倒着往栈里放

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % length]) {
                stack.pop();  // 矮个起开，反正也被挡着了
            }

            map.put(i % length, stack.isEmpty() ? -1 : nums[stack.peek()]);  // 当前元素身后的第一个高个
            stack.push(i % length);  // 进队，接受之后的身高判定

        }

        return map;
    }

    public static void main(String[] args) {
        int[] nums = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        int[] ints = new Leetcode503().nextGreaterElements1(nums);
        for (int num : ints) {
            System.out.print(num + "\t");
        }

    }
}
