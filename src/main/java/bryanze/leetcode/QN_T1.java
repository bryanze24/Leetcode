package bryanze.leetcode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/06
 */
public class QN_T1 {

//    static LinkedList<Integer> res = new LinkedList<>();
//    static LinkedList<Integer> path = new LinkedList<>();
    static StringBuilder res = new StringBuilder();
    static StringBuilder path = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        boolean[] used = new boolean[n];
        back(0, array, used);
        for (int i = 0; i < res.length() - 1; i++) {
            if (res.charAt(i) == '-') {
                System.out.print(res.charAt(i));
                System.out.print(res.charAt(i + 1) + " ");
                i++;
            } else {
                System.out.print(res.charAt(i) + " ");
            }
        }
        System.out.print(res.charAt(res.length() - 1));

    }

    private static void back(int index, int[] array, boolean[] used) {
        if (index == array.length) {
            if (res.length() == 0) {
                res.append(path);
            } else {
                if (path.toString().compareTo(res.toString()) < 0) {
                    res.delete(0, res.length());
                    res.append(path);
                }
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!used[i]) {
                path.append(array[i]);
                used[i] = true;
                back(index + 1, array, used);
                path.deleteCharAt(path.length() - 1);
                if(path.length() > 0 && path.charAt(path.length() - 1) == '-') {
                    path.deleteCharAt(path.length() - 1);
                }
                used[i] = false;
            }

        }
    }
}


class Main {

    static LinkedList<Integer> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        boolean[] used = new boolean[n];
        back(0, array, used);
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + " ");
        }
        System.out.print(res.get(res.size() - 1));

    }

    private static void back(int index, int[] array, boolean[] used) {
        if (path.size() == array.length) {
            if (res.isEmpty()) {
                res.addAll(path);
            } else {
                StringBuffer s1 = new StringBuffer();
                StringBuffer s2 = new StringBuffer();
                s1.append(path);
                s2.append(res);
//                for (int i = 0; i < path.size(); i++) {
//                    s1.append(path.get(i));
//                    s2.append(res.get(i));
//                }

                if (s1.toString().compareTo(s2.toString()) < 0) {
                    res.clear();
                    res.addAll(path);
                }

            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (!used[i]) {
                path.add(array[i]);
                used[i] = true;
                back(index + 1, array, used);
                path.removeLast();
                used[i] = false;
            }

        }
    }
}