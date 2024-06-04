package bryanze.leetcode;

import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * @author lizelin
 * @date 2024/06/04
 */
public class Leetcode155 {

    LinkedList<int[]> stack = new LinkedList<>();

    public Leetcode155() {

    }

    public void push(int val) {
        if (!stack.isEmpty()) {
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        } else {
            stack.push(new int[]{val, val});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek()[0];
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek()[1];
        } else {
            return -1;
        }
    }

}
