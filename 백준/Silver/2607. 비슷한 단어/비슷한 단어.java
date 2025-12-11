import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        // 1. 기준 단어 S 처리
        String s = in.readLine();
        int lenS = s.length();
        int[] cntS = new int[26];
        for (char c : s.toCharArray()) {
            cntS[c - 'A']++;
        }

        int ret = 0;
        // 2. 나머지 n-1개의 단어 N과 비교
        for (int i = 0; i < n - 1; i++) {
            String now = in.readLine();
            int lenN = now.length();
            int[] cntN = new int[26];
            for (char c : now.toCharArray()) {
                cntN[c - 'A']++;
            }

            // 길이 차이가 2 이상이면 무조건 비슷한 단어가 될 수 없음
            if (Math.abs(lenS - lenN) > 1) {
                continue; 
            }

            // 두 단어에서 공통으로 일치하는 알파벳 개수 (Match Count) 계산
            int matchCount = 0;
            for (int j = 0; j < 26; j++) {
                // 더 적은 쪽의 개수를 합산
                matchCount += Math.min(cntS[j], cntN[j]); 
            }

            // 비슷한 단어 조건 검사
            if (lenS == lenN) {
                // 1. 길이가 같을 때: 
                //    - matchCount == lenS: 같은 단어 (변화 0)
                //    - matchCount == lenS - 1: 한 글자 치환 (변화 1)
                //    (총 2글자가 다름: S에서 1개 줄고, N에서 1개 늘어난 경우)
                if (matchCount == lenS || matchCount == lenS - 1) {
                    ret++;
                }
            } else { // Math.abs(lenS - lenN) == 1 일 때
                // 2. 길이가 다를 때 (한 글자 추가/삭제):
                //    - matchCount == lenN: N이 S보다 1글자 많고, S의 모든 글자가 N에 포함됨
                //    - matchCount == lenS: S가 N보다 1글자 많고, N의 모든 글자가 S에 포함됨
                //    즉, Match Count는 더 긴 쪽의 길이보다 정확히 1 작아야 함
                int longerLength = Math.max(lenS, lenN);
                if (matchCount == longerLength - 1) {
                    ret++;
                }
            }
        }

        out.println(ret);
        out.flush();
        out.close();
    }
}