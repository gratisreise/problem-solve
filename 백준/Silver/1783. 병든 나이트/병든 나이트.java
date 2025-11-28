import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 행 (Height)
        int M = Integer.parseInt(st.nextToken()); // 열 (Width)

        int result = 0;

        // Case 1: N = 1
        if (N == 1) {
            result = 1;
        }
        // Case 2: N = 2
        else if (N == 2) {
            // 최대 4칸까지 방문 가능.
            // 이동 횟수 = floor((M-1)/2), 방문 칸 수 = 이동 횟수 + 1
            // min(4, 이동 횟수 + 1)
            // (M-1) / 2 가 아닌, (M+1)/2 의 올림으로 계산
            result = Math.min(4, (M + 1) / 2);
        }
        // Case 3: N >= 3
        else {
            // M이 7보다 작을 때: 4가지 이동을 모두 사용할 수 없는 경우
            // M칸을 모두 방문하거나, 4칸을 넘을 수 없음.
            // 이동 횟수 = M-1 (최대 M칸 방문)
            if (M < 7) {
                // min(4, M)이 아니라, min(4, M)을 방문 횟수로 봅니다.
                // M이 1일 때 1, M이 2일 때 2, M이 3일 때 3, M이 4, 5, 6일 때 4
                result = Math.min(4, M);
            }
            // M이 7 이상일 때: 4가지 이동을 모두 사용하고 최대한 많이 이동 가능
            // 4번의 필수 이동을 위해 6칸을 소모하고, 남은 M-6 칸에 대해
            // 최대한 오른쪽으로 2칸씩 이동하면 M-2칸을 방문할 수 있습니다.
            else {
                result = M - 2;
            }
        }

        System.out.println(result);
    }
}