package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/09/25
 */
public class XL_T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] items = new long[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = sc.nextLong();
            items[i][1] = sc.nextLong();
        }
        System.out.println(max(items, k));

    }

    private static long max(long[][] items, int k) {
        Arrays.sort(items, (a, b) -> (int) (b[0] - a[0]));
        HashMap<Long, Long> categoryCount = new HashMap<>();
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long totalProfit = 0;
        int distinctCategories = 0;
        for (int i = 0; i < k; i++) {
            long profit  = items[i][0];
            long category = items[i][1];
            totalProfit += profit;
            categoryCount.put(category, categoryCount.getOrDefault(category, 0L) + 1);
            if (categoryCount.get(category) == 1){
                distinctCategories++;
            }
            minHeap.add(profit);
        }
        long maxElegance = totalProfit + (long) distinctCategories * distinctCategories;
        for (int i = k; i < items.length; i++) {
            long profit = items[i][0];
            long category = items[i][1];
            if (!categoryCount.containsKey(category)) {
                long minProfit = minHeap.poll();
                totalProfit -= minProfit;
                totalProfit += profit;
                categoryCount.put(category, 1L);
                distinctCategories++;
                minHeap.add(profit);
                maxElegance = Math.max(maxElegance, totalProfit + (long) distinctCategories * distinctCategories);
            }

        }
        return  maxElegance;
    }
}
