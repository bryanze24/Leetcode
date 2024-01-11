package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.*;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * @author lizelin
 * @date 2024/01/11
 */
public class Leetcode297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return preOrder(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] array = data.split(",");

        LinkedList<String> list = new LinkedList<>(Arrays.asList(array));

        return construct(list);
    }

    private String preOrder(TreeNode root,  String str) {

        if (root == null) {
            str += "None,";
        } else {
            str += root.val + ",";
            str = preOrder(root.left, str);
            str = preOrder(root.right, str);

        }
        return str;
    }

    private TreeNode construct(LinkedList<String> list) {
        if (list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = construct(list);
        root.right = construct(list);
        return root;

    }

    public String serialize1(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node != null) {
                res.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);

            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");

        return res.toString();
    }

    public TreeNode deserialize1(String data) {
        if (data.equals("[]")) return null;

        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }

            i++;

            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }

            i++;
        }

        return root;
    }
}
