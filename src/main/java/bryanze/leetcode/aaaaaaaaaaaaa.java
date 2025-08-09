package bryanze.leetcode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class aaaaaaaaaaaaa {
    static final int MOD = 100000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(a);
        long res = 0;
        long power = 1;
        for (int i = 0; i < n; i++) {
            res = (res + a[i] * power) % MOD;
            if (i < n - 1) {
                power = (power * 2) % MOD;
            }
        }
        System.out.println(res);
    }
}
