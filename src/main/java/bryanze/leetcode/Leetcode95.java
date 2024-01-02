package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点
 * 组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * @author lizelin
 * @date 2024/01/02
 */
public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {

        if (n == 0) {
            return new LinkedList<>();
        }

        return generateTrees(1, n);
    }

    /*
    回溯
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();

        if(start > end) {
            allTrees.add(null);
            return allTrees;
        }

        //枚举可行的根节点
        for (int i = start; i <= end; i++) {
            //获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            //获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            //从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = leftTree;
                    currTree.right = rightTree;
                    allTrees.add(currTree);
                }
            }

        }

        return allTrees;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode95().generateTrees(3));
    }
}
