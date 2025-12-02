import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        // PrintWriter 대신 System.out.println 사용으로 통일 (간결성)
        // var out = new PrintWriter(System.out); // 주석 처리

        var st = new StringTokenizer(in.readLine());
        int width = Integer.parseInt(st.nextToken()); // 가로 길이 (n)
        int height = Integer.parseInt(st.nextToken()); // 세로 길이 (m)
        int k = Integer.parseInt(in.readLine());

        // 1. 자르기 경계선을 저장할 리스트 초기화
        List<Integer> cutCols = new ArrayList<>();
        List<Integer> cutRows = new ArrayList<>();

        // 2. 초기 경계선 추가 (이것이 예외 처리를 줄이는 핵심입니다)
        cutCols.add(0);
        cutCols.add(width);
        cutRows.add(0);
        cutRows.add(height);

        // 3. 입력 받은 자르기 위치 추가
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(in.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 0: 가로 자르기, 1: 세로 자르기
            int pos = Integer.parseInt(st.nextToken());

            // 문제 조건: dir=0 가로(세로방향 조각 결정), dir=1 세로(가로방향 조각 결정)
            if(dir == 0) { // 가로 자르기 (세로 조각 결정)
                cutRows.add(pos);
            } else { // 세로 자르기 (가로 조각 결정)
                cutCols.add(pos);
            }
        }

        Collections.sort(cutCols);
        Collections.sort(cutRows);

        int max_width = findMaxSegment(cutCols);
        int max_height = findMaxSegment(cutRows);

        System.out.println(max_width * max_height);
    }

    /**
     * 정렬된 경계선 리스트에서 인접한 두 점 사이의 최대 거리를 찾는 함수
     * @param points 자르기 위치 목록 (0과 전체 길이를 포함해야 함)
     * @return 최대 길이 조각의 길이
     */
    private static int findMaxSegment(List<Integer> points) {
        int maxLen = 0;
        // 리스트의 크기는 최소 2 (0과 끝점)
        for (int i = 1; i < points.size(); i++) {
            // 인접한 두 경계선 사이의 거리가 조각의 길이
            int segmentLen = points.get(i) - points.get(i - 1);
            maxLen = Math.max(maxLen, segmentLen);
        }
        return maxLen;
    }
}