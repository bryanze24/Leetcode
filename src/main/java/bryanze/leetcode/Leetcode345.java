package bryanze.leetcode;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */

public class Leetcode345 {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int slow = 0, fast = array.length - 1;

        while (slow < fast) {
            while (slow < array.length && isVowel(array[slow])) {
                slow++;
            }
            while (fast > 0 && isVowel(array[fast])) {
                fast--;
            }
            if (slow < fast) {
                swap(array, slow, fast);
                slow++;
                fast--;
            }
        }

        return new String(array);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) < 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        String s = "hello";
        String str = new Leetcode345().reverseVowels(s);
        System.out.println(str);
    }
}
