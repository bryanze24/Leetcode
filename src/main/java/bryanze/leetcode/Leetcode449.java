package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，
 * 或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 *
 * @author lizelin
 * @date 2024/01/03
 */
public class Leetcode449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        String string = list.toString();
        return string.substring(1, string.length() - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] array = data.split(", ");
        Stack<Integer> stack = new Stack<>();
        for (String str : array) {
            stack.push(Integer.parseInt(str));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }

    private TreeNode construct(int low, int high, Stack<Integer> stack) {

        if (stack.isEmpty() || stack.peek() < low || stack.peek() > high) {
            return null;
        }

        Integer value = stack.pop();
        TreeNode root = new TreeNode(value);

        root.right = construct(value, high, stack);
        root.left = construct(low, value, stack);
        return root;
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(1), 2, new TreeNode(3));
        String serialize = new Leetcode449().serialize(root);
        System.out.println(new Leetcode449().deserialize(serialize));
    }
}
