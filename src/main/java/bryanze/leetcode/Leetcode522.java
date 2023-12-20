package bryanze.leetcode;

/**
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。
 * "aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 *
 * @author lizelin
 * @date 2023/12/18
 */
public class Leetcode522 {
    public int findLUSLength(String[] strs) {

//        Arrays.sort(strs, String::compareTo);

        int result = -1;

        int length = strs.length;

        for (int i = 0; i < length; i++) {

            /*
            如果strs[i]的长度小于等于result，即使它不是任何字符串的子序列，
            结果也不会保留下来，所以没必要进行下去
             */
            if(strs[i].length() > result){

                boolean flag = true;

                for (int j = 0; j < length; j++) {
                    if (i == j) { // 不和自身检测
                        continue;
                    }

                    //如果检查出strs[i]是某个字符串的子序列，就没必要在继续检查了，跳出循环
                    if (isSubSequence(strs[i], strs[j])) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result = Math.max(strs[i].length(), result);
                }

            }
        }

        return result;
    }

    private boolean isSubSequence(String str1, String str2) {
        int p1 = 0, p2 = 0;
        while (p1 < str1.length() && p2 < str2.length()) {
            if (str1.charAt(p1) == str2.charAt(p2)) {
                p1++;
            }
            p2++;
        }

        return p1 == str1.length();
    }

    public static void main(String[] args) {
        String[] strs = {"aaa", "aaa", "aa"};
        System.out.println(new Leetcode522().findLUSLength(strs));
    }

}
