package bryanze.datastructure.hashtable;


/**
 * @author lizelin
 * @date 2023/11/24
 */
public class HashTable {

    static class Entry {
        int hash; //哈希码
        Object key; //键
        Object value; //值
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    Entry[] table = new Entry[16];
    int size = 0; //元素个数
    float loadFactor = 0.75f; //阈值12
    int threshold = (int) (loadFactor * table.length);

    /*
    求模运算替换为位运算
        - 前提：数组长度是 2 的 n 次方
        - hash % 数组长度 等价于 hash & (数组长度 - 1)
     */

    //根据hash码获取 value
    public Object get(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }

        Entry p = table[idx];

        while (p != null) {
            if (p.key.equals(key)) {
                return p.value;
            }
            p = p.next;
        }

        return null;
    }

    //向 hash 表存入新的 key value，如果 key 重复， 则更新 value
    public void put(int hash, Object key, Object value) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) { // idx处有空位，直接新增
            table[idx] = new Entry(hash, key, value);
        } else { // idx处无空位，沿链表查找 有重复key更新，否则新增
            Entry p = table[idx];
            while (true) {

                if (p.key.equals(key)) { // 更新
                    p.value = value;
                    return;
                }
                if (p.next == null) {
                    break;
                }
                p = p.next;
            }

            p.next = new Entry(hash, key, value); // 新增
        }
        size++;

        if(size > threshold){
            resize();
        }
    }

    private void resize() {
        Entry[] newTable = new Entry[table.length << 1];
        for (int i = 0; i < table.length; i++) {
            Entry p = table[i];
            if(p != null){
                //拆分链表，移动到新数组
                /*
                    拆分链表，移动到新数组，拆分规律
                    * 一个链表最多拆成两个
                    * hash & table.length == 0 的一组
                    * hash & table.length != 0 的一组
                 */
                Entry a = null;
                Entry b = null;
                Entry aHead = null;
                Entry bHead = null;
                while (p != null) {
                    if ((p.hash & table.length) == 0) {
                        if (a != null) {
                            a.next = p;
                        } else {
                            aHead = p;
                        }
                        a = p; // 分配到a
                    } else {
                        if (b != null) {
                            b.next = p;
                        } else {
                            bHead = p;
                        }
                        b = p; // 分配到b
                    }
                    p = p.next;
                }
                // 规律： a 链表保持索引位置不变，b 链表索引位置+table.length
                if (a != null) {
                    a.next = null;
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    newTable[i + table.length] = bHead;
                }
            }

        }
        table = newTable;
        threshold = (int) (loadFactor * table.length);
    }


    //根据hash码删除，返回删除的value
    public Object remove(int hash, Object key) {
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            return null;
        }

        Entry p = table[idx];
        Entry prev = null;
        while (p != null) {

            if (p.key.equals(key)) {
                //找到了删除
                if (prev == null) {
                    table[idx] = p.next;
                } else {
                    prev.next = p.next;
                }
                size--;
                return p.value;
            }
            prev = p;
            p = p.next;
        }

        return null;
    }

    public Object get(Object key) {
        int hash = hash(key);
        return get(hash, key);
    }

    public void put(Object key, Object value) {
        int hash = hash(key);
        put(hash, key, value);
    }

    public Object remove(Object key) {
        int hash = hash(key);
        return remove(hash, key);
    }

     private static int hash(Object key) {
        return key.hashCode();
     }

}
