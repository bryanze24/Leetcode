package bryanze.leetcode;

import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 * 注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author lizelin
 * @date 2024/06/04
 */
public class Leetcode394 {
    public String decodeString(String s) {
        String res = "";
        LinkedList<Integer> numStack = new LinkedList<>();
        LinkedList<String> strStack = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res = res + s.charAt(i);
            } else if (s.charAt(i) == '[') {
                numStack.push(num);
                num = 0;
                strStack.push(res);
                res = "";
            } else {
                Integer numTemp = numStack.pop();
                String string = strStack.peek();
                for (int j = 0; j < numTemp; j++) {
                    string += res;
                }
                res = string;
                strStack.pop();
            }
        }

        return res;
    }

}
