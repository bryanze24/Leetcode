package bryanze.leetcode;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */

public class Leetcode541 {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int length = array.length; //7
        for (int i = 0; i < length; i += 2*k) {

            if(length - i >= 2*k || length - i >= k && length - i < 2*k){
                reverse(array, i, i + k - 1);
            }

            if(length - i < k){
                reverse(array, i, length - 1);
            }

        }
        return new String(array);

    }

    private void reverse(char[] array, int slow, int fast){
        while(slow < fast){
            char temp = array[slow];
            array[slow] = array[fast];
            array[fast] = temp;
            slow++;
            fast--;
        }
    }

    public static void main(String[] args) {
        String str = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
        String target = "jlnnxsetgcpsbhsfymrkhfursyissjnsocgdhgfxtxrlvugsaphqzxllwebukgatzfybprfmmfithphccxfsogsgqsnvckjvnskk";
        System.out.println(target.equals(new Leetcode541().reverseStr(str, 20)));
    }
}
