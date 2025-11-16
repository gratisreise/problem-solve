import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken()); // 현재 랭킹 리스트에 있는 점수의 개수 (N <= P)
        int score = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 오를 수 있는 최대 개수

        // 1. 점수 리스트 생성 및 입력 (N개의 기존 점수)
        List<Integer> scores = new ArrayList<>();
        if (N > 0) {
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                scores.add(Integer.parseInt(st.nextToken()));
            }
        }

        // 2. 랭킹 리스트 꽉 참 && 진입 실패 조건 체크 (태수의 점수 추가 전)
        // N == P 일 때, 태수의 점수가 현재 P등의 점수보다 낮거나 같다면 진입 불가능
        if (N == P) {
            // 정렬 없이 P번째 점수(N-1 인덱스)를 찾기 위해 N개 점수를 정렬
            scores.sort(Collections.reverseOrder());

            // scores는 N개의 기존 점수만 포함. N=P일 때, N-1 인덱스가 P등의 점수.
            if (scores.get(N - 1) >= score) {
                out.println(-1);
                out.flush();
                out.close();
                return;
            }
        }

        // 3. 내 점수 추가 및 전체 정렬
        scores.add(score);
        scores.sort(Collections.reverseOrder());

        // 4. 태수 점수의 등수 계산
        int rank = 1;
        int count = 0; // 현재 등수에서 동점자 수
        int prevScore = -1;
        int myRank = -1;

        for (int i = 0; i < scores.size(); i++) {
            int currentScore = scores.get(i);

            // 랭킹 리스트 P개의 범위 초과 시 종료
            if (i >= P) break;

            if (currentScore != prevScore) {
                // 점수가 바뀔 때 등수 갱신
                rank = i + 1;
                count = 1;
            } else {
                // 동점자 처리
                count++;
            }

            if (currentScore == score) {
                // 태수 점수를 찾았을 때
                myRank = rank;
                // 만약 이 위치가 P번째(i == P-1)이고,
                // 뒤에 동점자가 더 있더라도 P개까지만 랭크에 오르므로 여기서 종료
                break;
            }

            prevScore = currentScore;
        }

        out.println(myRank);

        out.flush();
        out.close();
    }
}