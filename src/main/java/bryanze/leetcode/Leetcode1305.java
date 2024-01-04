package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，
 * 其中包含 两棵树 中的所有整数并按 升序 排序。
 *
 * @author lizelin
 * @date 2024/01/04
 */
public class Leetcode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);

        int i= 0;
        int j= 0;

        while (i < list1.size() && j < list2.size()) {
            if(list1.get(i) <= list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            }else{
                list3.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            list3.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list3.add(list2.get(j));
            j++;
        }

        return list3;
    }

    public List<Integer> getAllElements1(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list = new ArrayList<>();

        dfs(root1, list);
        dfs(root2, list);

        list.sort(Integer::compareTo);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }
}
