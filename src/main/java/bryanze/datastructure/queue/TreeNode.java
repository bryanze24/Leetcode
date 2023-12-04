package bryanze.datastructure.queue;

/**
 * 二叉树结构
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
    }


    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

}
