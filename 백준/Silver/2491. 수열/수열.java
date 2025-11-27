import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.Math; // Math.max를 사용하기 위해 import

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 순열의 크기 N 입력
        int N = Integer.parseInt(br.readLine());

        // N이 1일 때는 무조건 1을 출력하고 종료 (Edge Case)
        if (N == 1) {
            System.out.println(1);
            return;
        }

        // 2. 순열 A 입력
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 변수 초기화
        // N >= 2 이므로 초기 최대 길이는 1로 설정
        int max_len = 1;

        // 증가하거나 같은 수열의 길이
        int inc_len = 1;

        // 감소하거나 같은 수열의 길이
        int dec_len = 1;

        // 4. 두 번째 원소부터 순회하며 길이 계산 (i=1부터 시작)
        for (int i = 1; i < N; i++) {

            // --- 4-1. 증가하는(또는 같은) 수열 길이 갱신 ---
            if (A[i] >= A[i-1]) {
                // 이전 값보다 크거나 같으면 길이 증가
                inc_len++;
            } else {
                // 작아지면 연속성이 깨지므로 1로 초기화
                inc_len = 1;
            }

            // --- 4-2. 감소하는(또는 같은) 수열 길이 갱신 ---
            if (A[i] <= A[i-1]) {
                // 이전 값보다 작거나 같으면 길이 증가
                dec_len++;
            } else {
                // 커지면 연속성이 깨지므로 1로 초기화
                dec_len = 1;
            }

            // --- 4-3. 최대 길이 갱신 ---
            // 현재까지의 inc_len, dec_len 중 가장 큰 값으로 max_len을 갱신
            max_len = Math.max(max_len, inc_len);
            max_len = Math.max(max_len, dec_len);
        }

        // 5. 최종 결과 출력
        System.out.println(max_len);
    }
}