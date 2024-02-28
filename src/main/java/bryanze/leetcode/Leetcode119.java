package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author lizelin
 * @date 2024/02/28
 */
public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> cur = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(ans.get(j - 1) + ans.get(j));
                }

            }

            ans = cur;

        }

        return ans;

    }


    public List<Integer> getRowByRecursion(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }

        List<Integer> prev = getRowByRecursion(rowIndex - 1);
        List<Integer> cur = new ArrayList<>();

        cur.add(1);

        for (int i = 1; i < rowIndex; i++) {
            cur.add(prev.get(i - 1) + prev.get(i));

        }

        cur.add(1);

        return cur;
    }

    public static void main(String[] args) {
        List<Integer> row = new Leetcode119().getRow(5);
        System.out.println(row);
    }
}
