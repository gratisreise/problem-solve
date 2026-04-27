class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playSec = toSecond(play_time);
        int advSec = toSecond(adv_time);

        // 1. 차이 배열(Difference Array) 선언
        // 최대 99:59:59이므로 360,000 정도의 크기가 필요해.
        long[] totalTime = new long[playSec + 1];

        // 2. 기록 마킹 (IMOS 1단계)
        for (String log : logs) {
            String[] split = log.split("-");
            int start = toSecond(split[0]);
            int end = toSecond(split[1]);
            totalTime[start]++;
            totalTime[end]--; // end 시점에는 시청이 끝났으므로 -1
        }

        // 3. 첫 번째 누적 합: 특정 시점의 '시청자 수' 구하기
        for (int i = 1; i <= playSec; i++) {
            totalTime[i] += totalTime[i - 1];
        }

        // 4. 두 번째 누적 합: 0초부터 특정 시점까지의 '누적 재생 시간' 구하기
        // 이 시점부터 totalTime[i]는 0~i초까지의 시청 시간 총합이 됨!
        for (int i = 1; i <= playSec; i++) {
            totalTime[i] += totalTime[i - 1];
        }

        // 5. 슬라이딩 윈도우로 최적의 구간 찾기
        long maxTime = totalTime[advSec - 1]; // 0초에 광고 시작했을 때
        int maxStart = 0;

        for (int i = 0; i + advSec <= playSec; i++) {
            // i+1초부터 i+advSec초까지의 구간합 계산
            // 공식: (0 ~ i+advSec)까지의 합 - (0 ~ i)까지의 합
            long currTime = totalTime[i + advSec] - totalTime[i];

            if (currTime > maxTime) {
                maxTime = currTime;
                maxStart = i + 1;
            }
        }

        return toTime(maxStart);
    }

    // HH:MM:SS -> Seconds
    private int toSecond(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 3600 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
    }

    // Seconds -> HH:MM:SS
    private String toTime(int seconds) {
        int h = seconds / 3600;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}