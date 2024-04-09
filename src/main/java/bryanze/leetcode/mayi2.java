package bryanze.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class mayi2 {

    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }

        back(board, x, y, 0, 0);

        System.out.println(ans);
    }

    public static void back(char[][] board, int xx, int yy, int row, int col) {
        if (xx == 0 && yy == 0) {
            ans++;
            return;
        }

//        if (col == 3) {
//            back(board, xx, yy, row + 1, 0);
//        }

//        if (col >= 3 || row >= 3) {
//            return;
//        }
//
//        col = col % 3;
//        row = row % 3;


//        if (xx > 0 && isValid(board, row, col, 'D')) {
//            board[row][col] = 'D';
//            back(board, xx - 1, yy, row, col + 1);
//            board[row][col] = '.';
//        }
//
//        if (yy > 0 && isValid(board, row, col, 'M')) {
//            board[row][col] = 'M';
//            back(board, xx, yy - 1, row, col + 1);
//            board[row][col] = '.';
//        }


        for (int j = col; j < 3; j++) {

            if (xx > 0 && isValid(board, row, j, 'D')) {
                board[row][j] = 'D';
                back(board, xx - 1, yy, row, col + 1);
                board[row][j] = '.';

            } else if (yy > 0 && isValid(board, row, j, 'M')) {
                board[row][j] = 'M';
                back(board, xx, yy - 1, row, col + 1);
                board[row][j] = '.';
            }

        }


    }

    public static boolean isValid(char[][] board, int row, int col, char c) {

        if (row > 0 && board[row - 1][col] == c) {
            return false;
        }

        if (col > 0 && board[row][col - 1] == c) {
            return false;
        }

        return true;
    }
}
