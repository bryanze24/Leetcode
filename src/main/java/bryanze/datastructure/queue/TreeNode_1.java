package bryanze.datastructure.queue;

public class TreeNode_1 {
    public String val;
    public TreeNode_1 left;
    public TreeNode_1 right;

    public TreeNode_1() {

    }

    public TreeNode_1(String val) {
        this.val = val;
    }

    public TreeNode_1(TreeNode_1 left, String val, TreeNode_1 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
