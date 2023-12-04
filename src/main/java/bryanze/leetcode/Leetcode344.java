package bryanze.leetcode;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */

public class Leetcode344 {

    public void reverseString(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        while(slow < fast){
            char temp = s[slow];
            s[slow] = s[fast];
            s[fast] = temp;

            slow++;
            fast--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new Leetcode344().reverseString(s);
        System.out.println(s);
    }
}
