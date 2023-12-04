package bryanze.leetcode;

import java.util.PriorityQueue;

@SuppressWarnings("all")
public class Leetcode295_2 {

    //大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
    );

    //小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {

        if (left.size() == right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }

    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
