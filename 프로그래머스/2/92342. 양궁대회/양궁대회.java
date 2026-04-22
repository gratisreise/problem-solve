import java.util.*;

class Solution {
    int[] info; // 어피치의 화살 정보
    int[] ret = {-1}; // 정답 배열 (기본값 -1)
    int maxDiff = -1; // 최대 점수 차이

    public int[] solution(int n, int[] info) {
        this.info = info;
        // 0번 인덱스(10점)부터 탐색 시작
        go(0, n, new int[11]);
        
        return ret;
    }

    private void go(int idx, int remain, int[] ryan) {
        // 모든 점수판(10점 ~ 0점)을 다 결정했을 때
        if (idx == 11) {
            // 화살을 다 썼을 때만 점수 계산 (남은 화살은 이미 idx 10에서 처리됨)
            int diff = calc(ryan);
            
            if (diff > 0) { // 라이언이 이긴 경우에만
                if (diff > maxDiff) {
                    maxDiff = diff;
                    ret = ryan.clone();
                } else if (diff == maxDiff) {
                    // 점수 차이가 같다면, 낮은 점수를 더 많이 맞힌 경우 선택
                    if (isBetter(ryan)) {
                        ret = ryan.clone();
                    }
                }
            }
            return;
        }

        // 마지막 0점 과녁(idx 10)에서는 남은 화살을 전부 다 써야 함
        if (idx == 10) {
            ryan[idx] = remain;
            go(idx + 1, 0, ryan);
            ryan[idx] = 0; // 백트래킹 원복
        } else {
            // 이번 과녁(idx)에 0발부터 남은 화살(remain)까지 다 쏴보기
            for (int i = 0; i <= remain; i++) {
                ryan[idx] = i;
                go(idx + 1, remain - i, ryan);
                ryan[idx] = 0; // 백트래킹 원복
            }
        }
    }

    private int calc(int[] ryan) {
        int ryanScore = 0;
        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && ryan[i] == 0) continue; // 둘 다 0발이면 점수 없음
            
            if (ryan[i] > info[i]) {
                ryanScore += (10 - i);
            } else {
                apeachScore += (10 - i);
            }
        }
        return ryanScore - apeachScore;
    }

    private boolean isBetter(int[] ryan) {
        // 낮은 점수(인덱스 뒤쪽)부터 비교하여 더 많이 맞힌 쪽을 선택
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > ret[i]) return true;
            if (ryan[i] < ret[i]) return false;
        }
        return false;
    }
}