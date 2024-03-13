package bryanze.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * @author lizelin
 * @date 2024/03/13
 */
public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {

                while (!stack.isEmpty() &&  temperatures[i] > temperatures[stack.peek()]) {
                    Integer popped = stack.pop();
                    ans[popped] = i - popped;
                }

                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            Integer popped = stack.pop();
            ans[popped] = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 69, 72, 76, 73};
        System.out.println(Arrays.toString(new Leetcode739().dailyTemperatures(temperatures)));
    }

}
