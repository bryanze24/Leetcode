package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/09/06
 */
public class YY_T3 {

    static boolean[][] isGold;

    public static void main(String[] args) {

    }

    public int goldenFinger(int n, int m) {
        // write code here
        isGold = new boolean[n][m];
        int energy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isGold[i][j]) {
                    int maxSide = getMaxSquareSide(i, j, n, m);
                    cover(i,j,maxSide);
                    energy++;
                }

            }

        }
        return energy;

    }

    public void cover(int x, int y,int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                isGold[i][j] = true;
            }

        }
    }

    public int getMaxSquareSide(int x, int y, int n, int m) {
        int maxSide = 0;
        while (true) {
            if (x + maxSide >= n || y + maxSide >= m) {
                break;
            }

            for (int i = 0; i <= maxSide; i++) {
                if (isGold[x + maxSide][y + i] || isGold[x + i][y + maxSide]) {
                    return maxSide;
                }
            }

            maxSide++;

        }
        return maxSide;
    }
}
