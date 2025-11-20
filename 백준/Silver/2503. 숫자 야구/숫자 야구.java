import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static class Question {
        String number;
        int strike;
        int ball;

        public Question(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Question[] questions = new Question[N];

        // 1. 입력 처리: N개의 질문 정보를 배열에 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            questions[i] = new Question(num, s, b);
        }

        int possibleCount = 0;

        // 2. 완전 탐색 (Brute Force): 123부터 987까지 모든 3자리 숫자 탐색
        for (int i = 123; i <= 987; i++) {
            String candidate = String.valueOf(i);
            
            // 3. 후보 필터링: 서로 다른 1~9 숫자로만 구성되었는지 확인
            if (!isValidCandidate(candidate)) {
                continue;
            }

            // 4. 검증 루프: 이 후보가 모든 질문 조건을 만족하는지 확인
            boolean isPossible = true;
            for (Question q : questions) {
                // 후보(candidate)와 질문(q.number)을 비교하여 S, B를 계산
                int[] result = calculateStrikeAndBall(candidate, q.number);
                int calculatedStrike = result[0];
                int calculatedBall = result[1];

                // 계산된 S, B가 질문의 정답 S, B와 다르면 이 후보는 탈락
                if (calculatedStrike != q.strike || calculatedBall != q.ball) {
                    isPossible = false;
                    break;
                }
            }

            // 5. 카운트: 모든 질문을 통과한 경우 정답 개수 증가
            if (isPossible) {
                possibleCount++;
            }
        }

        System.out.println(possibleCount);
    }
    
    private static boolean isValidCandidate(String s) {
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char c3 = s.charAt(2);

        // 0이 포함되면 무효
        if (c1 == '0' || c2 == '0' || c3 == '0') {
            return false;
        }

        // 숫자가 중복되면 무효
        if (c1 == c2 || c1 == c3 || c2 == c3) {
            return false;
        }

        return true;
    }
    
    private static int[] calculateStrikeAndBall(String target, String guess) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 숫자가 같은지 확인
                if (target.charAt(i) == guess.charAt(j)) {
                    if (i == j) {
                        // 위치도 같으면 스트라이크
                        strike++;
                    } else {
                        // 위치는 다르면 볼
                        ball++;
                    }
                }
            }
        }

        return new int[]{strike, ball};
    }
}