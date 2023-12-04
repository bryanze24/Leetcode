package bryanze.datastructure.redblacktree;


import static bryanze.datastructure.redblacktree.RedBlackTree.Color.BLACK;
import static bryanze.datastructure.redblacktree.RedBlackTree.Color.RED;

/**
 * 红黑树
 */

public class RedBlackTree {

    enum Color {
        RED,
        BLACK
    }

    private Node root;

    private static class Node {
        int key;
        Object value;
        Node left;
        Node right;
        Node parent; //父节点
        Color color = RED;

        public Node() {
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        //是否是左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        //找叔叔节点
        Node uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }

            if (this.parent.isLeftChild()) {
                return this.parent.parent.right;
            } else {
                return this.parent.parent.left;
            }
        }

        //找兄弟节点
        Node sibling() {
            if (parent == null) {
                return null;
            }

            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }

    }

    // 判断颜色 红，黑
    boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    boolean isBlack(Node node) {
        return node == null || node.color == BLACK;
    }

    //右旋 1.parent的处理；2.在方法内部建立新根的父子关系
    public void rightRotate(Node pink) {
        Node parent = pink.parent;

        Node yellow = pink.left;
        Node green = yellow.right;

        if (green != null) {
            green.parent = pink;
        }

        yellow.right = pink;
        yellow.parent = parent;

        pink.left = green;
        pink.parent = yellow;

        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    //左旋
    public void leftRotate(Node pink) {
        Node parent = pink.parent;

        Node yellow = pink.right;
        Node green = yellow.left;

        if (green != null) {
            green.parent = pink;
        }

        yellow.left = pink;
        yellow.parent = parent;

        pink.right = green;
        pink.parent = yellow;

        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }

    }

    /**
     * 新增或更新
     * 正常增、遇到红红不平衡进行调整
     * @param key   键
     * @param value 值
     */
    public void put(int key, Object value) {
        Node p = root;
        Node parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                p.value = value; // 更新
                return;
            }
        }

        Node inserted = new Node(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }

    private void fixRedRed(Node inserted) {
        // case 1 插入节点是根节点，变黑即可
        if (inserted == root) {
            inserted.color = BLACK;
            return;
        }
        // case 2 插入节点父亲是黑色，无需调整
        if (isBlack(inserted.parent)) {
            return;
        }

        /*
        case 3 当红红相邻，叔叔为红时
        需要将父亲、叔叔变黑、祖父变红，然后对祖父做递归处理
        */
        Node parent = inserted.parent;
        Node uncle = inserted.uncle();
        Node grandparent = parent.parent;
        if (isRed(uncle)) {
            parent.color = BLACK;
            assert uncle != null;
            uncle.color = BLACK;
            grandparent.color = RED;
            fixRedRed(grandparent);
            return;
        }

        // case 4 当红红相邻，叔叔为黑时
        if (parent.isLeftChild() && inserted.isLeftChild()) { // LL
            parent.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (parent.isLeftChild()) { // LR
            leftRotate(parent);
            inserted.color = BLACK;
            grandparent.color = RED;
            rightRotate(grandparent);
        } else if (!inserted.isLeftChild()) { // RR
            parent.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        } else { // RL
            rightRotate(parent);
            inserted.color = BLACK;
            grandparent.color = RED;
            leftRotate(grandparent);
        }
    }

    // 查找删除节点
    private Node find(int key) {
        Node p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    // 查找剩余节点
    private Node findReplaced(Node deleted) {
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        if (deleted.left == null) {
            return deleted.right;
        }
        if (deleted.right == null) {
            return deleted.left;
        }
        Node s = deleted.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }

    /**
     * 删除
     * 正常删、会用到李代桃僵技巧、遇到黑黑不平衡进行调整
     *
     * @param key 键
     */
    public void remove(int key) {
        Node deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    private void doRemove(Node deleted) {
        Node replaced = findReplaced(deleted);
        Node parent = deleted.parent;
        if (replaced == null) {//没有孩子
            //case1 删除的是根节点
            if (deleted == root) {
                root = null;
            } else {
                if(isBlack(deleted)){
                    //复杂调整
                    fixDoubleBlack(deleted);
                }else{
                    //红色叶子，无需处理
                }

                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                deleted.parent = null;
            }
            return;
        }

        if (deleted.left == null || deleted.right == null) { //有一个孩子
            //case1 删除的是根节点
            if (deleted == root) {
                root.key = replaced.key;
                root.value = replaced.value;
                root.left = root.right = null;
            } else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                //help GC
                deleted.left = null;
                deleted.right = null;
                deleted.parent = null;
                if(isBlack(deleted) && isBlack(replaced)){
                    //复杂处理
                    fixDoubleBlack(replaced);
                }else{
                    //case2
                    replaced.color = BLACK;
                }
            }
            return;
        }

        //case0:有两个孩子 =>有一个孩子或者没有孩子的情况
        int kTemp = deleted.key;
        deleted.key = replaced.key;
        replaced.key = kTemp;

        Object vTemp = deleted.value;
        deleted.value = replaced.value;
        replaced.value = vTemp;

        doRemove(replaced);

    }

    private void fixDoubleBlack(Node x){
        if (x == root) {
            return;
        }

        Node parent = x.parent;
        Node sibling = x.sibling();
        // case 3 兄弟节点是红色
        if (isRed(sibling)) {
            if (x.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }

            parent.color = RED;
            assert sibling != null;
            sibling.color = BLACK;
            fixDoubleBlack(x);
            return;
        }

        if (sibling != null) {
            // case 4 兄弟是黑色, 两个侄子也是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = RED;
                if (isRed(parent)) {
                    parent.color = BLACK;
                } else {
                    fixDoubleBlack(parent);
                }
            }
            // case 5 兄弟是黑色, 侄子有红色
            else {
                // LL
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = BLACK;
                    sibling.color = parent.color;
                }
                // LR
                else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }
                // RL
                else if (!sibling.isLeftChild() && isRed(sibling.left)) {
                    sibling.left.color = parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }
                // RR
                else {
                    leftRotate(parent);
                    sibling.right.color = BLACK;
                    sibling.color = parent.color;
                }
                parent.color = BLACK;
            }
        } else {
            // TODO 实际也不会出现，触发双黑后，兄弟节点不会为 null
            fixDoubleBlack(parent);
        }

    }

}
