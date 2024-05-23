package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author lizelin
 * @date 2024/05/20
 */
public class Leetcode22 {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtracking(n, 0, 0);
        return ans;
    }

    private void backtracking(int n, int left, int right) {
        if (left == n && right == n) { // 左右括号都使用了n个
            ans.add(sb.toString());
            return;
        }

        if (left < n) { //左括号使用个数小于n，表示还有剩余
            sb.append("(");
            backtracking(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) { // 右括号数量小于左括号，如 ((), 这种情况下可以添加右括号
            sb.append(")");
            backtracking(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> list = new Leetcode22().generateParenthesis(5);
        for (String str : list) {
            System.out.print(str + " ");
        }
    }
}
