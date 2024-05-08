import java.util.*;

public class Solution {
    static int n, ret;
    static int[] a;

    static int check(int idx) {
        int x = idx - 2;
        int y = idx + 2;
        int ans = 0;
        for (int i = Math.max(x, 0); i <= Math.min(y, 1000); i++) {
            if (i == idx) continue;
            ans = Math.max(a[i], ans);
        }
        if (a[idx] - ans <= 0) return 0;

        return a[idx] - ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int k = 1; k <= 10; k++) {
            ret = 0;
            a = new int[1004];
            n = sc.nextInt();
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n; i++) ret += check(i);

            System.out.println("#" + k + " " + ret);
        }

    }
}

/*
1. 해당 인덱스에서 양쪽 길이 2 이내에 자기보다 높은 건물이 없으면 ++

 */