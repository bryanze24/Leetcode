package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */

public class Leetcode501 {

    List<Integer> answer = new ArrayList<>();
    int num, count, maxCount;

    public int[] findMode(TreeNode root) {
        recursion(root);

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }

        recursion(root.left);

        update(root.val);

        recursion(root.right);
    }

    private void update(int value) {
        if (value == num) {
            count++;
        } else {
            count = 1;
            num = value;
        }

        if(count == maxCount){
            answer.add(num);
        }

        if(count > maxCount){
            maxCount = count;
            answer.clear();
            answer.add(num);
        }
    }
}
