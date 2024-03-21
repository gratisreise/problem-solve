class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    // 최소공배수(LCM)를 구하는 메서드
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    public int[] solution(int n, int m) {
        int[] ret = {gcd(n, m), lcm(n, m)};
        return ret;
    }
}