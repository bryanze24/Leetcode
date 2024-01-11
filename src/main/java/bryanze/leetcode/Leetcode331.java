package bryanze.leetcode;

import java.util.Stack;

/**
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，
 * 我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 * @author lizelin
 * @date 2024/01/11
 */
public class Leetcode331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();

        String[] array = preorder.split(",");

        for (String str : array) {
            stack.push(str);

            while (stack.size() >= 3 &&
                    stack.get(stack.size() - 1).equals("#") &&
                    stack.get(stack.size() - 2).equals("#") &&
                    !stack.get(stack.size() - 3).equals("#")) {

                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }

        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

    public boolean isValidSerialization1(String preorder) {
        String[] array = preorder.split(",");

        int diff = 1;

        for (String str : array) {
            diff--;

            if (diff < 0) {
                return false;
            }

            if (!str.equals("#")) {
                diff += 2;
            }

        }

        return diff == 0;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.get(stack.size() - 1));

    }
}
