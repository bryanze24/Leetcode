package bryanze.leetcode;

import java.util.*;

/**
 * @author lizelin
 * @date 2024/04/06
 */
public class xhst3 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        long[] b = new long[n - 1];
//        long[] c = new long[n - 1];
//
//        for (int i = 0; i < n - 1; i++) {
//            b[i] = in.nextLong();
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            c[i] = in.nextLong();
//        }
//
//        Arrays.sort(b);
//        Arrays.sort(c);
//        long[] b1 = new long[n - 1];
//        long[] c1 = new long[n - 1];
//        b1[0] = b[0];
//        c1[0] = c[0];
//        for (int i = 1; i < n - 1; i++) {
//            b1[i] = b[i] - b[i - 1];
//            c1[i] = c[i] - c[i - 1];
//        }
//
//        long[] a = new long[n];
//        a[0] = Math.min(b[0], c[0]);
//        long sum = 0;
//        for (int i = 1; i < n - 1; i++) {
//            if (b[i] != c[i]) {
//                long bError = b[i] - b[i - 1];
//                long cError = c[i] - c[i - 1];
//
//                a[i] = cError == b1[i - 1] ? bError : cError;
//                sum += a[i];
//            } else {
//                a[i] = b[i] = b[i - 1];
//            }
//        }
//
//
//
//        a[n - 1] = Math.max(b[n - 2], c[n - 2]) - sum;
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i] + " ");
//        }
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        long[] b = new long[n - 1];
//        long[] c = new long[n - 1];
//
//        for (int i = 0; i < n - 1; i++) {
//            b[i] = in.nextLong();
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            c[i] = in.nextLong();
//        }
//
//        Arrays.sort(b);
//        Arrays.sort(c);
//
//        long[] b1 = new long[n - 1];
//        long[] c1 = new long[n - 1];
//        b1[0] = b[0];
//        c1[0] = c[0];
//
//        for (int i = 1; i < n - 1; i++) {
//            b1[i] = b[i] - b[i - 1];
//            c1[i] = c[i] - c[i - 1];
//        }
//
//        long[] a = new long[n];
////        a[0] = Math.min(b1[0], c1[0]);
//        for (int i = 0; i < n - 1; i++) {
//            if (b1[i] == c1[i]) {
//                a[i] = b1[i];
//            } else {
//                if (b1[i] == c1[i + 1]){
//                    a[i] = b1[i];
//                } else if (c1[i] == b1[i + 1]){
//                    a[i] = c1[i];
//                }
//            }
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i] + " ");
//        }
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums1 = new long[n - 1];
        long[] nums2 = new long[n - 1];

        for (int i = 0; i < n - 1; i++) {
            nums1[i] = sc.nextLong();
        }

        for (int i = 0; i < n - 1; i++) {
            nums2[i] = sc.nextLong();
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        getOldNum(nums1);
        getOldNum(nums2);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }

        int curr1 = 0, curr2 = 0;
        List<Long> ans = new ArrayList<>();
        while (curr1 < nums1.length && curr2 < nums2.length) {
            if (nums1[curr1] == nums2[curr2]) {
                ans.add(nums1[curr1]);
                curr1++;
                curr2++;
            } else {
                if (nums1[curr1 + 1] == nums2[curr2]) {
                    ans.add(nums1[curr1]);
                    curr1++;
                }else if (nums1[curr1] == nums2[curr2 + 1]) {
                    ans.add(nums2[curr1]);
                    curr2++;
                }
            }
        }

        if (ans.contains(nums1[nums1.length - 1]) && !ans.contains(nums2[nums1.length - 1])) {
            ans.add(nums2[nums2.length - 1]);
        }else if (!ans.contains(nums1[nums1.length - 1]) && ans.contains(nums2[nums1.length - 1])) {
            ans.add(nums1[nums1.length - 1]);
        }

        for (long i: ans) {
            System.out.print(i + " ");
        }

    }

    private static void getOldNum(long[] nums) {
        long[] oldNum = new long[nums.length];
        oldNum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            oldNum[i] = nums[i] - nums[i- 1];

        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = oldNum[i];
        }
    }
}
