package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author lizelin
 * @date 2024/03/09
 */
public class Leetcode17 {

    List<String> ans = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return ans;
        }

        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(numString, digits, builder, 0);
        return ans;
    }

    private void backTracking(String[] numString, String digits,
                              StringBuilder builder, int length) {
        if (length == digits.length()) {
            ans.add(builder.toString());
            return;
        }

        String str = numString[digits.charAt(length) - '0'];
        for (int i = 0; i < str.length(); i++) {

            builder.append(str.charAt(i));
            //回溯
            backTracking(numString, digits, builder, builder.length());
            //剔除末尾
            builder.deleteCharAt(builder.length() - 1);
        }

    }

    public static void main(String[] args) {
        List<String> list = new Leetcode17().letterCombinations("234");
        for (String string : list) {
            System.out.println(string);
        }
    }
}
