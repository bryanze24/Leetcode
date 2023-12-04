package bryanze.leetcode;


/**
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。
 * 如果数组元素个数小于 2，则返回 0 。
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 * @author lizelin
 * @date 2023/11/30
 */
public class Leetcode164 {
    public int maximumGap(int[] nums) {

        // 1. 处理特殊情况
        if (nums.length < 2) {
            return 0;
        }

        // 2. 桶排序
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[i] < min) {
                min = nums[i];
            }
        }
        // 2.1 准备桶
        /*
            计算桶个数                   期望桶个数
            (max - min) / range + 1 = nums.length + 1
            (max - min) / range = nums.length

         */
        int range = Math.max((max - min) / nums.length, 1); // 让桶的个数比元素多一个
        int bucketSize = (max - min) / range + 1;
        System.out.println("range:" + range + " 桶个数" + bucketSize);
        Pair[] buckets = new Pair[(max - min) / range + 1];

        // 2.2 放入数据
        for (int v : nums) {
            int idx = (v - min) / range;
            if (buckets[idx] == null) {
                buckets[idx] = new Pair();
            }
            buckets[idx].add(v);
        }

        for (Pair bucket : buckets) {
            System.out.println(bucket);
        }

        /*
            [12,10] 0
            [22,20] 1
            [30,30] 2
            null    3
            [40,40] 4
         */
        // 3. 寻找最大差值
        int r = 0;
        int lastMax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            Pair bucket = buckets[i];
            if (bucket != null) {
                r = Math.max(r, bucket.min - lastMax);
                lastMax = bucket.max;
            }
        }
        return r;
    }

    // 数据范围 0 <= nums[i] <= 1000_000_000
    static class Pair {
        int max = 0;
        int min = 1000_000_000;

        void add(int v) { // 桶内最大最小
            max = Math.max(v, max);
            min = Math.min(v, min);
        }
        @Override
        public String toString() {
            return "[" + max +
                    "," + min +
                    ']';
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 10000000};
//        int[] nums = {9, 1, 3, 5};
//        int[] nums = {1, 1, 1, 1};
//        int[] nums = {1, 1, 1, 1, 1, 5, 5, 5, 5, 5};
//        int[] nums = {15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740};
        /*
            有没有可能，桶内元素的间距比桶间元素间距还大？ 有空桶
                [10]   9
                [19 25]      6
         */
        int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 220};
        int r = new Leetcode164().maximumGap(nums);
        System.out.println(r);
    }
}
