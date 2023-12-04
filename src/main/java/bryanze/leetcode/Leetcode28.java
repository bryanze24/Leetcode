package bryanze.leetcode;

/**
 * 给你两个字符串 haystack 和 needle,
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */

public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();

        int p1 = 0;
        int p2 = 0;
        int count = 0;

        while(p1 < hArray.length && p2 <nArray.length){
            if(hArray[p1] == nArray[p2]){
                p1++;
                p2++;
                count++;
            }else{
                count = 0;
                p1 = p1 - p2;
                p1++;
                p2 = 0;
            }

            if(count == nArray.length){
                return p1 - nArray.length;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "ssad";
        String str2 = "sad";
        System.out.println(new Leetcode28().strStr(str1, str2));
    }
}
