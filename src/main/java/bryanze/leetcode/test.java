package bryanze.leetcode;

import bryanze.datastructure.queue.Deque;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author lizelin
 * @date 2024/11/19
 */
public class test {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperature(temperatures);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println(Arrays.toString(ans));
    }

    public static int[] dailyTemperature(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
