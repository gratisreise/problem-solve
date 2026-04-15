import java.util.*;

class Solution {
    private int toMinutes(String time) {
        String[] tt = time.split(":");
        return Integer.parseInt(tt[0]) * 60 + Integer.parseInt(tt[1]);
    }

    private String toTimes(int minutes) {
        return String.format("%02d:%02d", minutes / 60, minutes % 60);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        // 1. 크루들 도착 시간 정렬
        int[] ttable = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            ttable[i] = toMinutes(timetable[i]);
        }
        Arrays.sort(ttable);

        int busTime = toMinutes("09:00");
        int crewIdx = 0;
        int lastCrewTime = 0; // 마지막으로 탄 크루의 시간
        int count = 0;        // 현재 버스에 탄 인원

        // 2. n번의 버스를 순차적으로 운행
        for (int i = 0; i < n; i++) {
            count = 0;
            // 해당 버스에 탈 수 있는 크루들을 태움 (최대 m명)
            while (crewIdx < ttable.length && ttable[crewIdx] <= busTime && count < m) {
                lastCrewTime = ttable[crewIdx]; // 마지막으로 탄 사람 기록
                crewIdx++;
                count++;
            }
            
            // 마지막 버스가 아니면 다음 버스 시간으로 갱신
            if (i < n - 1) busTime += t;
        }

        // 3. 마지막 버스(busTime) 상황에 따른 정답 도출
        int answer = 0;
        if (count < m) {
            // 자리가 남았다면? 버스 도착 시간에 딱 맞춰 가면 됨
            answer = busTime;
        } else {
            // 자리가 없다면? 마지막으로 탄 사람보다 1분 빨리 와야 함
            answer = lastCrewTime - 1;
        }

        return toTimes(answer);
    }
}