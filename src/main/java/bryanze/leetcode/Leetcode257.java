package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * @author lizelin
 * @date 2024/01/10
 */
public class Leetcode257 {

    //广度优先搜索
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) { //叶子结点
                paths.add(path);

            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(path + "->" + node.left.val);
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(path + "->" + node.right.val);
                }
            }
        }

        return paths;
    }

    //深度优先搜索
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();

        dfs(root, "", paths);

        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {

        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            paths.add(sb.toString());

        } else {

            sb.append("->");

            if (root.left != null) {
                dfs(root.left, sb.toString(), paths);
            }

            if (root.right != null) {
                dfs(root.right, sb.toString(), paths);
            }

        }

    }
}
