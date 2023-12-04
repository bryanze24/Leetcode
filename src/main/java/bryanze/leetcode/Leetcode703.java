package bryanze.leetcode;

import bryanze.datastructure.heap.MinHeap2;

public class Leetcode703 {

    private final MinHeap2 heap;

    public Leetcode703(int k, int[] nums) {
        heap = new MinHeap2(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if(!heap.isFull()){
            heap.offer(val);
        }else if(heap.peek() < val){
            heap.replace(val);
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        Leetcode703 test = new Leetcode703(3, new int[]{4, 5, 8, 2});
        System.out.println(test.add(3));
        System.out.println(test.add(5));
        System.out.println(test.add(10));
        System.out.println(test.add(9));
        System.out.println(test.add(4));
    }
}
