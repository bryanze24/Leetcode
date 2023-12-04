package bryanze.leetcode;

import bryanze.datastructure.heap.Heap;

/**
 * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
 * 例如 arr = [2,3,4] 的中位数是 3 。
 * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
 * 实现 MedianFinder 类:
 * MedianFinder() 初始化 MedianFinder 对象。
 * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
 * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
 */

public class Leetcode295_1 {
    /*
     * 为了保证两边数据量的平衡
     * 两边个数一样时,左边个数加一
     * 两边个数不一样时,右边个数加一
     * 但是, 随便一个数能直接加入吗?
     * 左边个数加一时, 把新元素加在右边，弹出右边最小的加入左边
     * 右边个数加一时, 把新元素加在左边，弹出左边最小的加入右边
     */

    private Heap left = new Heap(10, true);
    private Heap right = new Heap(10, false);

    public void addNum(int num) {
        if (left.getSize() == right.getSize()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    /*
     *两边数据一致, 左右各取堆顶元素求平均
     *左边多一个, 取左边堆顶元素
     */
    public double findMedian() {
        if (left.getSize() == right.getSize()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
