package bryanze.leetcode;

import bryanze.datastructure.queue.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

public class LeetcodeLCR193 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root.val < p.val && root.val < q.val || root.val > p.val && root.val > q.val){
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        TreeNode n1 = root;
        TreeNode n2 = root;
        while(n1.val != p.val){
            l1.add(n1);
            if(n1.val < p.val){
                n1 = n1.right;
            }else{
                n1 = n1.left;
            }
        }
        l1.add(n1);
        while(n2.val != q.val){
            l2.add(n2);
            if(n2.val < q.val){
                n2 = n2.right;
            }else{
                n2 = n2.left;
            }
        }

        l2.add(n2);
        TreeNode ancestor = null;
        for(int i = 0; i < Math.min(l1.size(),l2.size()); i++){
            if(l1.get(i) == l2.get(i)){
                ancestor = l1.get(i);
            }else{
                break;
            }

        }
        return ancestor;
    }
}
