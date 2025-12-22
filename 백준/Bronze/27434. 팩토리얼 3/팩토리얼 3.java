import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 0!과 1!은 항상 1
        if (N == 0 || N == 1) {
            System.out.println(1);
        } else {
            System.out.println(solve(1, N));
        }
        
        sc.close();
    }

    // 분할 정복을 이용한 팩토리얼 계산
    public static BigInteger solve(int start, int end) {
        // base case: 숫자가 하나인 경우 그 값을 BigInteger로 반환
        if (start == end) {
            return BigInteger.valueOf(start);
        }
        
        // 범위를 반으로 나누어 재귀 호출
        int mid = (start + end) / 2;
        return solve(start, mid).multiply(solve(mid + 1, end));
    }
}