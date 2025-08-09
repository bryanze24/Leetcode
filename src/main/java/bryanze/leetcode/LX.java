package bryanze.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int q = Integer.parseInt(split[1]);
        int[] a = new int[n];
        String[] split1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(split1[i]);
        }
        int[] query = new int[q];
        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < q; i++) {
            query[i] = Integer.parseInt(split2[i]);

        }
        Set<Long> possible = new HashSet<>();

        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += a[i];
            possible.add(prefixSum);

        }

        long suffixSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum += a[i];
            possible.add(suffixSum);
        }
        StringBuilder result = new StringBuilder();
        for (int w : query) {
            if (possible.contains((long) w)) {
                result.append("YES ");
            } else {
                result.append("NO ");
            }

        }
        System.out.println(result.toString());

    }
}
