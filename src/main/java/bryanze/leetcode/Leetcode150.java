package bryanze.leetcode;

import java.util.LinkedList;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 */
public class Leetcode150 {

    public int evalRPN(String[] tokens) {

        LinkedList<Integer> stack = new LinkedList<>();
        for (String str : tokens) {
            switch(str){
                case "+":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a+b);
                    break;
                }
                case "-":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a-b);
                    break;
                }
                case "*":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a*b);
                    break;
                }
                case "/":{
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a/b);
                    break;
                }
                default:{
                    stack.push(Integer.parseInt(str));
                }
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
       String[] tokens = {"4","13","5","/","+"};
        System.out.println(new Leetcode150().evalRPN(tokens));
    }
}
