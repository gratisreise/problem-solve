import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 빠른 입출력을 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 2. 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 5; i <= N; i *= 5) {
                count += N / i;
                if (N / 5 < i) break; 
            }

            sb.append(count).append("\n");
        }

        // 4. 결과 한꺼번에 출력
        System.out.print(sb.toString());
    }
}