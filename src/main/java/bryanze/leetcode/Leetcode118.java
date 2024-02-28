package bryanze.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author lizelin
 * @date 2024/02/28
 */
public class Leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    temp.add(1);
                } else {
                    int value = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    temp.add(value);
                }
            }

            ans.add(temp);
        }

        return ans;
    }

    public List<List<Integer>> generateByGpt(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        //第一行始终是1
        ans.add(new ArrayList<>());
        ans.get(0).add(1);

        for (int row = 1; row < numRows; row++) {
            List<Integer> prevRow = ans.get(row - 1);
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(1);

            for (int i = 1; i < row; i++) {
                temp.add(prevRow.get(i - 1) + prevRow.get(i));
            }

            temp.add(1);
            ans.add(temp);

        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new Leetcode118().generateByGpt(5);
        for (List<Integer> integerList : list) {
            System.out.println(integerList);
        }
    }
}
