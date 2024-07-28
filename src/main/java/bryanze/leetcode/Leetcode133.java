package bryanze.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。
 * 例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 *
 * @author lizelin
 * @date 2024/07/28
 */
public class Leetcode133 {
    static HashMap<Node, Node> hashMap = new HashMap<>();

    //BFS
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Node clone = new Node(node.val, new ArrayList<>());
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, clone);
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node t : temp.neighbors) {
                if (!map.containsKey(t)) {
                    map.put(t, new Node(t.val, new ArrayList<>()));
                    queue.offer(t);
                }
                map.get(temp).neighbors.add(map.get(t));
            }
        }

        return clone;
    }

    //DFS
    public Node cloneGraphDFS(Node node) {
        if (node == null) {
            return null;
        }

        return dfs(node);
    }

    private Node dfs(Node node) {
        if (hashMap.containsKey(node)) {
            return hashMap.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());
        hashMap.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {

    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}

