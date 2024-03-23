package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/03/23
 */
public class CodeFun1723 {

    static LinkedList<Integer> res = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int num = sc.nextInt();
            nums[i] = num;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n - 1; j++) {
                int a = sc.nextInt();
                list.add(a);
            }
            map.put(num, list);
        }

        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            backTrack(map, nums[i]);
        }

    }

    public static void backTrack(Map<Integer, List<Integer>> map, int num) {
        if (flag) {
            return;
        }

        if (res.contains(num)) {
            int index = res.indexOf(num);
            for (int i = index; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.print(num);
            flag = true;
            return;
        }

        if (map.containsKey(num)) {
            res.add(num);
            List<Integer> list = map.get(num);
            for (Integer number : list) {
                backTrack(map, number);
            }
            res.removeLast();
        }

    }

}
