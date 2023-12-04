package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode_1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 根据后缀表达式构造表达式树
 */

public class ExpressionTree {

    /*
    1.遇到数字入栈
    2.遇到运算符出栈，建立节点联系，在入栈
     */
    public TreeNode_1 constructExpressionTree(String[] tokens) {
        LinkedList<TreeNode_1> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    method(token, stack);

                case "-":
                    method(token, stack);

                case "*":
                    method(token, stack);

                case "/":
                    method(token, stack);

                default: //数字
                    stack.push(new TreeNode_1(token));
            }
        }
        return stack.peek();
    }

    private static void method(String token, LinkedList<TreeNode_1> stack) {
        TreeNode_1 right = stack.pop();
        TreeNode_1 left = stack.pop();
        TreeNode_1 parent = new TreeNode_1(token);
        parent.left = left;
        parent.right = right;
        stack.push(parent);
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "-", "3", "*"};
        TreeNode_1 treeNode = new ExpressionTree().constructExpressionTree(tokens);
        ArrayList<String> result = new ArrayList<>();
        post(treeNode, result);
        System.out.println(result);
    }

    private static void post(TreeNode_1 node, ArrayList<String> result) {
        if (node == null) {
            return;
        }

        post(node.left, result);
        post(node.right, result);
        result.add(node.val);
    }

}
