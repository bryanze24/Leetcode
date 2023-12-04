package bryanze.leetcode;


import java.util.Stack;


/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Leetcode20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }else if( c == '{'){
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');

            }else {
                if(!stack.isEmpty() && c == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode20 s = new Leetcode20();
        System.out.println(s.isValid("([{}])"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("()"));
        System.out.println("---------------------");

        System.out.println(s.isValid("[)"));
        // ]
        System.out.println(s.isValid("([)]"));
        // ) ]
        System.out.println(s.isValid("([]"));
        // )
        System.out.println(s.isValid("("));

        System.out.println("---------------------");
        System.out.println(s.isValid(")("));
        System.out.println(s.isValid("]"));
    }
}
