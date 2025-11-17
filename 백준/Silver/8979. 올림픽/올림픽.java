import java.io.*;
import java.util.*;

public class Main {

    // 두 국가의 메달 점수(금, 은, 동)가 완전히 동일한지 확인하는 함수
    static boolean isSameMedals(int idx1, int idx2, int[][] arr) {
        // 인덱스는 arr 배열의 행 인덱스 (0부터 시작)
        return arr[idx1][1] == arr[idx2][1] && // 금메달
            arr[idx1][2] == arr[idx2][2] && // 은메달
            arr[idx1][3] == arr[idx2][3];  // 동메달
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter는 필요 없으므로 제거

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken()); // 국가 수
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가 번호

        // arr[i][0]은 국가 번호, arr[i][1]~[3]은 메달 수
        int[][] arr = new int[n][4];

        // l: 정렬할 국가 번호 리스트. 초기 순서는 입력 순서.
        List<Integer> l = new ArrayList<>();
        // mp: 국가 번호(key) -> arr 배열의 행 인덱스(value) 매핑
        Map<Integer, Integer> countryToIndexMap = new HashMap<>();

        // 데이터 입력 및 매핑
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            int countryId = arr[i][0];
            l.add(countryId);
            countryToIndexMap.put(countryId, i); // 국가 번호 -> arr 배열 인덱스 저장
        }

        // --- 내림차순 정렬 로직 (이전 로직 유지) ---
        l.sort((a, b) -> {
            int aa = countryToIndexMap.get(a); // 국가 a의 arr 인덱스
            int bb = countryToIndexMap.get(b); // 국가 b의 arr 인덱스

            // 1. 금메달 (내림차순)
            if (arr[aa][1] != arr[bb][1]) {
                return Integer.compare(arr[bb][1], arr[aa][1]); // arr[b] > arr[a]이면 양수 -> b가 앞으로
            }

            // 2. 금메달이 같으면, 은메달 (내림차순)
            if (arr[aa][2] != arr[bb][2]) {
                return Integer.compare(arr[bb][2], arr[aa][2]); // arr[b] > arr[a]이면 양수 -> b가 앞으로
            }

            // 3. 은메달까지 같으면, 동메달 (내림차순)
            return Integer.compare(arr[bb][3], arr[aa][3]); // arr[b] > arr[a]이면 양수 -> b가 앞으로
        });

        // --- 등수 계산 및 K 국가 찾기 로직 개선 ---

        // 1등 국가는 정렬된 리스트의 0번째
        int prevCountryId = l.get(0);
        int prevIndex = countryToIndexMap.get(prevCountryId);

        // K 국가가 1등인 경우 바로 출력
        if (prevCountryId == k) {
            System.out.println(1);
            return;
        }

        int currentRank = 1; // 현재 순위
        int sameRankCount = 1; // 이전 그룹과 같은 점수를 가진 국가 수 (공동 등수 카운트)

        for (int i = 1; i < l.size(); i++) {
            int currentCountryId = l.get(i);
            int currentIndex = countryToIndexMap.get(currentCountryId);

            // 이전 국가(prevCountryId)와 현재 국가(currentCountryId) 비교
            if (isSameMedals(prevIndex, currentIndex, arr)) {
                // 메달 순위가 같으면 -> 공동 등수
                sameRankCount++;
            } else {
                // 메달 순위가 다르면 -> 새로운 등수 그룹 시작
                currentRank += sameRankCount; // 현재 등수 + 이전 공동 등수 수 = 새로운 등수
                sameRankCount = 1; // 새로운 그룹의 카운트는 1로 시작
            }

            // 등수 비교/업데이트 후, 찾는 국가(K)인지 확인
            if (currentCountryId == k) {
                System.out.println(currentRank);
                return;
            }

            // 다음 반복을 위해 prev 업데이트
            prevCountryId = currentCountryId;
            prevIndex = currentIndex;
        }
    }
}