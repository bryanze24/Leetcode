package bryanze.datastructure.btree;

import java.util.Arrays;

/**
 * @author lizelin
 * @date 2023/11/23
 */
public class BTree {

    static class Node {
        int[] keys; //关键字
        Node[] children; //孩子
        int keyNumber; //有效关键字数目
        boolean isLeaf = true; //是否是叶子节点
        int t; //最小度数

        public Node(int t) { // t>=2
            this.t = t;
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        //多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (keys[i] == key) {
                    return this;
                }

                if (keys[i] > key) {
                    break;
                }

                i++;
            }

            //执行到这里，说明keys[i] > key 或者 i = keyNumber
            if (isLeaf) {
                return null;
            }

            //非叶子节点
            return children[i].get(key);
        }

        //向指定索引出插入 key
        void insertKey(int key, int index) {
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        //向指定索引处插入 child
        void insertChild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1, keyNumber - index);
            children[index] = child;
        }

        // 移除指定 index 处的 key
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, keyNumber - index);
            keyNumber--;
            return t;
        }

        // 移除最左边的 key
        int removeLeftmostKey() {
            return removeKey(0);
        }

        // 移除最右边的 key
        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }

        // 移除指定 index 处的 child
        Node removeChild(int index) {
            Node t = children[index];
            System.arraycopy(children, index + 1, children, index, keyNumber - index);
            children[keyNumber] = null; // help GC
            return t;
        }

        // 移除最左边的 child
        Node removeLeftmostChild() {
            return removeChild(0);
        }

        // 移除最右边的 child
        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }

        // index 孩子处左边的兄弟
        Node childLeftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        // index 孩子处右边的兄弟
        Node childRightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }

        // 复制当前节点的所有 key 和 child 到 target
        void moveToTarget(Node target) {
            int start = target.keyNumber;
            if (!isLeaf) {
                if (keyNumber + 1 >= 0) {
                    System.arraycopy(children, 0, target.children, start, keyNumber + 1);
                }
            }

            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }

    }

    Node root;
    int t; //树中节点最小度数
    final int MIN_KEY_NUMBER; // 最小key数目
    final int MAX_KEY_NUMBER; // 最大key数目

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MAX_KEY_NUMBER = 2 * t - 1;
        MIN_KEY_NUMBER = t - 1;

    }

    public BTree() {
        this(2);
    }

    //是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }

    //新增
    public void put(int key) {
        doPut(root, key, null, 0);
    }

    private void doPut(Node node, int key, Node parent, int index) {
        int i = 0;

        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return;//更新
            }

            if (node.keys[i] > key) {
                break; //找到了插入位置，即为i
            }
            i++;
        }

        if (node.isLeaf) {
            node.insertKey(key, i);
            //达到上限
        } else {
            doPut(node.children[i], key, node, i);
            //达到上限
        }

        if (node.keyNumber == MAX_KEY_NUMBER) {
            split(node, parent, index);
        }

    }


    void split(Node left, Node parent, int index) {

        //分裂的是根节点
        if (parent == null) {
            Node newRoot = new Node(t);
            newRoot.isLeaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }

        //1. 创建 right 节点，把 left 中 t 之后的 key 和 child 移动过去
        Node right = new Node(t);
        right.isLeaf = left.isLeaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);

        //分裂节点是非叶子节点的情况
        if (!left.isLeaf) {
            System.arraycopy(left.children, t, right.children, 0, t);
        }

        right.keyNumber = t - 1;
        left.keyNumber = t - 1;

        //2. 中间的 key (t-1处) 插入到父节点
        int mid = left.keys[t - 1];
        parent.insertKey(mid, index);

        //3. right 节点作为父节点的孩子
        parent.insertChild(right, index + 1);

    }

    //删除
    public void remove(int key) {
        doRemove(null, root, 0, key);
    }

    private void doRemove(Node parent, Node node, int index, int key) {
        int i = 0;

        while (i < node.keyNumber) {
            if (node.keys[i] >= key) {
                break;
            }
            i++;
        }

        // i 找到，代表待删除 key 的索引
        // i 没找到，代表到第 i 个孩子继续查找
        if (node.isLeaf) {
            if (!found(node, key, i)) { // case1 当前节点是叶子节点，没找到
                return;

            } else { // case2 当前节点是叶子节点，找到

                node.removeKey(i);
            }

        } else {
            if (!found(node, key, i)) { // case3 当前节点不是叶子节点，没找到

                doRemove(node, node.children[i], i, key);
            } else { // case4 当前节点不是叶子节点，找到

                Node s = node.children[i + 1];
                while (!s.isLeaf) {
                    s = s.children[0];
                }

                int sKey = s.keys[0];
                //2.替换删除 key
                node.keys[i] = sKey;

                //3.删除后继 key
                doRemove(node, node.children[i + 1], i + 1, sKey);

            }
        }

        if (node.keyNumber < MIN_KEY_NUMBER) {
            //调整平衡
            balance(parent, node, index);
        }

    }

    private void balance(Node parent, Node node, int index) {
        // case 6 根节点
        if (node == root) {
            if (root.keyNumber == 0 && root.children[0] != null) {
                root = root.children[0];
            }

            return;
        }

        Node left = parent.childLeftSibling(index);
        Node right = parent.childRightSibling(index);

        if (left != null && left.keyNumber > MIN_KEY_NUMBER) {
            //case 5-1 左边富裕，右旋
            // 1) 父节点中前驱 key 旋转下来
            node.insertKey(parent.keys[index - 1], 0);

            if (!left.isLeaf) { //非叶子结点时
                // 2) left 中最大的孩子换父节点
                node.insertChild(left.removeRightmostChild(), 0);
            }

            // 3) left 中最大的 key 旋转上去
            parent.keys[index - 1] = left.removeRightmostKey();

            return;
        }

        if (right != null && right.keyNumber > MIN_KEY_NUMBER) {
            //case 5-2 右边富裕，左旋
            // 1) 父节点中后继 key 旋转下来
            node.insertKey(parent.keys[index], node.keyNumber);

            if (!right.isLeaf) {//非叶子结点时
                // 2) right 中最小的孩子换父节点
                node.insertChild(right.removeLeftmostChild(), node.keyNumber + 1);
            }

            // 3) right 中最小的 key 旋转上去
            parent.keys[index] = right.removeLeftmostKey();
            return;
        }

        //case 5-3 两边都不够借，合并
        if (left != null) {
            //向左兄弟合并
            parent.removeChild(index); //被调整节点从父节点删除

            //将父节点的对应的key合并到左兄弟
            left.insertKey(parent.removeKey(index - 1), left.keyNumber);

            //将待调整节点移动到左兄弟里面
            node.moveToTarget(left);

        } else {
            //向自己合并
            parent.removeChild(index + 1);
            node.insertKey(parent.removeKey(index), node.keyNumber);
            right.moveToTarget(node);

        }

    }

    private static boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;
    }

}
