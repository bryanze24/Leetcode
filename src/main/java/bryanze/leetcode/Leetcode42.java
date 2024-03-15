package bryanze.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode42 {

    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈

                if (stack.empty()) { // 栈空就出去
                    break;
                }

                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;

    }

    public int trapByMonotonicStack(int[] height) {
        int length = height.length;
        LinkedList<Integer> stack = new LinkedList<>();

        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (stack.isEmpty() || height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }

                stack.push(i);
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Leetcode42().trapByMonotonicStack(height));
    }

}
