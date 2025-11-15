import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 설정
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String g1_original = in.readLine();
        String g2_original = in.readLine();

        // 1. 긴 톱니바퀴를 G1, 짧은 톱니바퀴를 G2로 설정하여 계산을 단순화합니다.
        // (길이가 같다면 순서는 상관없습니다.)
        String g1 = g1_original.length() >= g2_original.length() ? g1_original : g2_original;
        String g2 = g1_original.length() >= g2_original.length() ? g2_original : g1_original;

        int len1 = g1.length(); // 긴 톱니바퀴의 길이 (L1)
        int len2 = g2.length(); // 짧은 톱니바퀴의 길이 (L2)

        // 초기 최소 길이는 두 톱니바퀴를 전혀 겹치지 않고 붙였을 때의 길이 (L1 + L2)로 설정합니다.
        int min_length = len1 + len2;

        // 2. 슬라이딩 윈도우 방식으로 모든 겹침 위치를 순회합니다.
        // i: G2 톱니바퀴의 0번째 인덱스가 G1 톱니바퀴의 어디에 놓이는지를 나타내는 '오프셋'
        // i의 범위: -(L2 - 1) 부터 L1 - 1 까지
        // (G2의 오른쪽 끝(L2-1)이 G1의 0에 닿는 경우부터 G1의 오른쪽 끝(L1-1)에 G2의 0이 닿는 경우까지)

        for (int i = 1 - len2; i < len1; i++) {
            boolean collision = false;

            // 겹치는 구간을 순회하며 충돌 검사

            // G1의 인덱스 k가 겹침을 시작하는 지점: G1의 범위(0) 또는 G2의 시작점(i) 중 더 큰 인덱스
            int start_k = Math.max(0, i);

            // G1의 인덱스 k가 겹침을 끝내는 지점: G1의 끝(len1) 또는 G2의 끝(i + len2) 중 더 작은 인덱스
            int end_k = Math.min(len1, i + len2);

            for (int k = start_k; k < end_k; k++) {
                int j = k - i; // G2 톱니바퀴의 해당 인덱스

                // 충돌 조건: G1[k]의 '2'와 G2[j]의 '2'가 동시에 맞닿는 경우
                if (g1.charAt(k) == '2' && g2.charAt(j) == '2') {
                    collision = true;
                    break;
                }
            }

            // 3. 충돌이 없는 경우, 이 위치에서의 전체 길이를 계산하고 최소 길이를 갱신합니다.
            if (!collision) {
                // 전체 길이 L = (겹쳐진 전체 구간의 가장 오른쪽 인덱스 - 가장 왼쪽 인덱스) + 1
                // 가장 오른쪽 인덱스: max(G1의 끝 인덱스, G2의 끝 인덱스)
                // 가장 왼쪽 인덱스: min(G1의 시작 인덱스, G2의 시작 인덱스)

                // G1의 끝 인덱스: len1 - 1
                // G2의 끝 인덱스: i + len2 - 1
                int max_idx = Math.max(len1 - 1, i + len2 - 1);

                // G1의 시작 인덱스: 0
                // G2의 시작 인덱스: i
                int min_idx = Math.min(0, i);

                int current_length = max_idx - min_idx + 1;

                min_length = Math.min(min_length, current_length);
            }
        }

        out.println(min_length);

        out.flush();
        out.close();
    }
}