package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 后序 遍历(左，右，值)。
 */

public class Leetcode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; //代表当前节点
        TreeNode pop = null; //最近一次弹栈的元素

        List<Integer> result = new ArrayList<>();
        while(curr != null || !stack.isEmpty()){
            if(curr != null) {

                stack.push(curr); // 压入栈，记录回来时的路线
                //待处理左子树
                curr = curr.left;

            }else{
                TreeNode peek = stack.peek(); //栈顶元素

                // 没有右子树
                if(peek.right == null){
                    pop = stack.pop();
                    result.add(pop.val);
                    // 右子树处理完成
                } else if (peek.right == pop) {
                    pop = stack.pop();
                    result.add(pop.val);

                // 待处理右子树
                } else{
                    curr = peek.right;
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4),2,new TreeNode(7)),
                1,
                new TreeNode(new TreeNode(5),3,new TreeNode(6))
        );

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode curr = root; //代表当前节点
        TreeNode pop = null; //最近一次弹栈的元素

        while(curr != null || !stack.isEmpty()){
            if(curr != null) {

                stack.push(curr); // 压入栈，记录回来时的路线
                colorPrintln("前:" + curr.val,31);
                //待处理左子树
                curr = curr.left;

            }else{
                TreeNode peek = stack.peek(); //栈顶元素

                // 没有右子树
                if(peek.right == null){
                    colorPrintln("中:" + peek.val,36);
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val,34);
                // 右子树处理完成
                } else if (peek.right == pop) {
                    pop = stack.pop();
                    colorPrintln("后:" + pop.val,34);
                // 待处理右子树
                } else{
                    colorPrintln("中:" + peek.val,36);
                    curr = peek.right;
                }
            }

        }

    }

    private static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
