package bryanze.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * @author lizelin
 * @date 2024/03/09
 */
public class Leetcode216 {

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 0, 1);
        return ans;
    }

    private void dfs(int n, int k, int sum, int index) {
        if (path.size() == k && sum == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < 10; i++) {
            if (path.size() > k || sum > n) {
                break;
            }

            path.add(i);
            dfs(n, k, sum + i, i + 1);
            path.removeLast();
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Leetcode216().combinationSum3(3, 9);
        for (List<Integer> res : list) {
            System.out.println(res);
        }
    }

}
