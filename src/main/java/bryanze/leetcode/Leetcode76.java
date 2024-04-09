package bryanze.leetcode;

import java.util.HashMap;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * @author lizelin
 * @date 2024/04/09
 */
public class Leetcode76 {
    public String minWindow(String s, String t) {
        //效验参数
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        //记录t中字符出现的次数，表示每个字符待需要的数量
        HashMap<Character, Integer> need = new HashMap<>();

        //所需要的字符总数
        int needCnt = t.length();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        //记录结果的左右边界
        int[] minResult = new int[]{0, Integer.MAX_VALUE};
        int length = s.length();
        for (int i = 0, j = 0; j < length; j++) {
            char c = s.charAt(j);
            //若包含字符，则所需要的字符个数减1
            if (need.getOrDefault(c, 0) > 0) {
                needCnt--;
            }

            //更新need中所需要的字符个数
            need.put(c, need.getOrDefault(c, 0) - 1);

            //此时满足条件，需要更新左边界，尝试缩小窗口
            if (needCnt == 0) {
                while (true) {
                    c = s.charAt(i);

                    //说明左边界字符已经不能再缩小了，则退出循环
                    if (need.get(c) == 0) {
                        break;
                    }

                    //缩小左边界，则对应的字符所需要的数量 + 1
                    need.put(c, need.getOrDefault(c, 0) + 1);
                    i++;
                }

                //更新结果
                if (j - i < minResult[1] - minResult[0]) {
                    minResult[0] = i;
                    minResult[1] = j;
                }

                //左边界右移，执行下一个窗口
                //由于左边界是t需要的字符，右移后，需要更新need和needCnt
                c = s.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
                needCnt++;
                i++;

            }

        }

        if (minResult[1] > length) {
            return "";
        } else {
            return s.substring(minResult[0], minResult[1] + 1);
        }

    }

    public static void main(String[] args) {

    }
}
