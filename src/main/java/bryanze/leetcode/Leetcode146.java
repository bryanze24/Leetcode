package bryanze.leetcode;

import java.util.*;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，
 * 则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author lizelin
 * @date 2024/03/16
 */
public class Leetcode146 {

    static class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private LinkedNode head;
    private LinkedNode tail;
    private HashMap<Integer, LinkedNode> map = new HashMap<>();

    public Leetcode146(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = map.get(key);

        if (node == null) {
            LinkedNode linkedNode = new LinkedNode(key, value);
            map.put(key, linkedNode);
            addHead(linkedNode);
            size++;
            if (size > capacity) {
                LinkedNode deleteTail = removeTail();
                map.remove(deleteTail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }

    private void moveToHead(LinkedNode node) {
        //从原先位置移除
        removeNode(node);
        //加入头部
        addHead(node);
    }

    private LinkedNode removeTail() {
        // 最后一个节点
        LinkedNode node = tail.prev;
        // 删除该节点的逻辑
        removeNode(node);
        return node;
    }

    private void addHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
