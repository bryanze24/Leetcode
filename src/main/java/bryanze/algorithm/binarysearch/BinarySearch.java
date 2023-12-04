package bryanze.algorithm.binarysearch;

public class BinarySearch {

    public static int binarySearchBasic(int[] a , int target){

        int i = 0, j = a.length - 1;    // 设置指针和初值
        // L 次  元素在最左边 L 次，  元素在最右边 2*L 次
        while (i <= j) {                // i~j 范围内有东西
            int m = (i + j) >>> 1; //无符号右移运算
            if (target < a[m]) {         // 目标在左边
                j = m - 1;
            } else if (a[m] < target) { // 目标在右边
                i = m + 1;
            } else {                    // 找到了
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchAlternative(int[] a , int target){

        int i = 0, j = a.length;  //改动第一处
        while (i < j) {   //改动第二处
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;   //改动第三处
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {         // 范围内待查找的元素个数 > 1 时
            int m = (i + j) >>> 1;
            if (target < a[m]) {    // 目标在左边
                j = m;
            } else {                // 目标在 m 或右边
                i = m;
            }
        }
        return (target == a[i]) ? i : -1;
    }


    public static int binarySearchLeftmost1(int[] a, int target){
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                //记录候选位置
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /**
     *
     * @param a 待查找的升序数组
     * @param target  目标值
     * @return 返回 >= target的最靠左的索引位置
     */
    public static int binarySearchLeftmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     *
     * @param a 待查找的升序数组
     * @param target  目标值
     * @return 返回 <= target的最靠右的索引位置
     */
    public static int binarySearchRightmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }
}
