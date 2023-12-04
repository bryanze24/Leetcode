package bryanze.algorithm.binarysearch;

public class RecursionBinarySearch {

    public static int search(int[] a, int target){
        return function(a, target, 0, a.length - 1);
    }

    /**
     * 递归(子函数)函数
     * @param a 升序数组
     * @param target 目标值
     * @param low 起始索引
     * @param high 结束索引
     * @return 找到返回索引，未找到返回 -1
     */
    private static int function(int[] a, int target, int low, int high){
        if (low > high) {
            return -1;
        }

        int middle = (low + high) >>> 1;

        if (target < a[middle]) {
            return function(a, target,low, middle - 1);
        }else if (a[middle] < target){
            return function(a, target, middle + 1, high);
        }else{
            return middle;
        }
    }

}
