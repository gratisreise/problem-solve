import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 다이아몬드의 한 변 길이 (최대 10^18)
        long N = Long.parseLong(st.nextToken());
        // R1, C1: 시작 행/열, R2, C2: 끝 행/열 (최대 10^18)
        long R1 = Long.parseLong(st.nextToken());
        long C1 = Long.parseLong(st.nextToken());
        long R2 = Long.parseLong(st.nextToken());
        long C2 = Long.parseLong(st.nextToken());

        // 결과를 효율적으로 저장하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 패턴의 주기 (Period): 2 * N - 1
        long P = 2 * N - 1;
        // 중앙 좌표 (Center): N - 1
        long center = N - 1; // 0부터 시작이라서 n-1

        // R1부터 R2까지의 행을 순회합니다. (최대 50번)
        for (long R = R1; R <= R2; R++) {
            // C1부터 C2까지의 열을 순회합니다. (최대 50번)
            for (long C = C1; C <= C2; C++) {

                // 1. 주기성을 이용해 패턴 내 상대 좌표 (r, c) 계산
                // 좌표 숫자의 크기와 상관없이 주기에 의해서 좌표값 결정
                long r = R % P;
                long c = C % P;

                // 2. 중앙 좌표와의 맨해튼 거리 D 계산 (abs() 함수 사용)
                long D = Math.abs(r - center) + Math.abs(c - center);

                // 3. D에 따라 출력 문자 결정
                if (D >= N) {
                    // 다이아몬드 경계를 벗어남 (맨해튼 거리가 N 이상)
                    sb.append('.');
                } else {
                    // 알파벳 계산: 'a'를 기준으로 D만큼 떨어진 문자
                    // a=0, b=1, ..., z=25 이므로 D % 26을 사용합니다.
                    // 'a'의 아스키코드(97)에 D % 26을 더하면 원하는 알파벳을 얻을 수 있습니다.
                    char ch = (char) ('a' + (D % 26));
                    sb.append(ch);
                }
            }
            sb.append('\n'); // 한 행이 끝나면 줄바꿈
        }

        // 최종 결과 출력
        System.out.print(sb.toString());
    }
}
/*
중심부로부터의 거리가 좌표를 결정

 */