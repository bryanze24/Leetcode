package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.'
 * 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * @author lizelin
 * @date 2024/03/09
 */
public class Leetcode93 {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() <= 3 || s.length() > 12) {
            return ans;
        }

        backTracking(s, 0, 0);
        return ans;
    }

    private void backTracking(String s, int index, int pointNum) {

        if (pointNum == 3) {
            if (isValid(s, index, s.length() - 1)) {
                ans.add(s);
                return;
            }
        }

        for (int i = index; i < s.length(); i++) {
            if (isValid(s, index, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backTracking(s, i + 2, pointNum);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }

        }
    }


    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        if (s.charAt(start) == '0' && start != end) {
            return false;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {

            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > 255) {
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Leetcode93().restoreIpAddresses("101023"));
    }
}
