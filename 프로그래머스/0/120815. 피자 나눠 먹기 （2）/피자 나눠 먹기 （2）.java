
class Solution {
// 최대공약수를 구하는 메서드 (유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수를 구하는 메서드
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    public int solution(int n) {
        int ret = lcm(n, 6) / 6;;
        
        
        return ret;
    }
}