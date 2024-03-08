package bryanze.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 *
 * @author lizelin
 * @date 2024/03/08
 */
public class Leetcode77 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return ans;
    }

    private void dfs(int n, int k, int start) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) { //未剪枝
            path.add(i);
            dfs(n, k, i + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Leetcode77().combine(4, 2);
        for (List<Integer> path : list) {
            System.out.println(path);
        }
    }

}
