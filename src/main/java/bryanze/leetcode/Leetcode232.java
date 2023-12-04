package bryanze.leetcode;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class Leetcode232 {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) { //向队列尾添加
        s2.push(x);
    }

    public int pop() { //从队列头移除

        if(s1.empty()){
            while (!s2.empty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() { //从队列头获取
        if(s1.empty()){
            while (!s2.empty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();

    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
