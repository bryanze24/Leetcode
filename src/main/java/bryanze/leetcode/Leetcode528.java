package bryanze.leetcode;


/**
 * 给你一个 下标从 0 开始 的正整数数组 w ，其中 w[i] 代表第 i 个下标的权重。
 * 请你实现一个函数 pickIndex ，它可以 随机地 从范围 [0, w.length - 1] 内（含 0 和 w.length - 1）
 * 选出并返回一个下标。选取下标 i 的 概率 为 w[i] / sum(w) 。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），
 * 而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * @author lizelin
 * @date 2024/03/28
 */
public class Leetcode528 {
//    private int[] w;
    private int[] prifix;
    int total;
    public Leetcode528(int[] w) {
//        this.w = w;
        prifix = new int[w.length];
        prifix[0] = w[0];
        total = w[0];
        for (int i = 1; i < w.length; i++) {
            total += w[i];
            prifix[i] = prifix[i - 1] + w[i];
        }

    }

    public int pickIndex() {
        int i = (int) ((Math.random() * total) + 1);
        int left = 0, right = prifix.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (prifix[mid] < i) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

}
