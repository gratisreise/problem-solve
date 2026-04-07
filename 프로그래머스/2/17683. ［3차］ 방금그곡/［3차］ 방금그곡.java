import java.util.*;

class Solution {
    // #이 붙은 음들을 단일 문자로 치환하는 함수
    private String changeMelody(String s) {
        return s.replaceAll("C#", "c")
                .replaceAll("D#", "d")
                .replaceAll("F#", "f")
                .replaceAll("G#", "g")
                .replaceAll("A#", "a")
                .replaceAll("B#", "b"); // 문제에 따라 B#이 있을 수 있음
    }

    private int getMinutes(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;
        
        m = changeMelody(m); // 기억한 멜로디 치환

        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int playTime = getMinutes(info[1]) - getMinutes(info[0]);
            String title = info[2];
            String sheet = changeMelody(info[3]);

            // 재생 시간 동안 실제로 연주된 전체 악보 생성
            StringBuilder fullMelody = new StringBuilder();
            for (int j = 0; j < playTime; j++) {
                fullMelody.append(sheet.charAt(j % sheet.length()));
            }

            // 멜로디 포함 여부 확인
            if (fullMelody.toString().contains(m)) {
                // 조건: 재생 시간이 길고, 먼저 입력된 순서
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }
}