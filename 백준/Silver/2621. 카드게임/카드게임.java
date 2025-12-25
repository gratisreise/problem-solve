import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numCount = new int[10]; // 숫자별 개수 (1~9)
        int[] colors = new int[4];    // R:0, B:1, Y:2, G:3 (색상별 개수)
        int[] sortedNums = new int[5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char color = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            sortedNums[i] = num;
            numCount[num]++;
            if (color == 'R') colors[0]++;
            else if (color == 'B') colors[1]++;
            else if (color == 'Y') colors[2]++;
            else if (color == 'G') colors[3]++;
        }

        Arrays.sort(sortedNums); // 숫자를 정렬해두면 연속 판정이 매우 쉬워집니다.

        // 1. 미리 상태 분석 (Flag 세우기)
        boolean isSameColor = false;
        for (int c : colors) if (c == 5) isSameColor = true;

        boolean isContinuous = true;
        for (int i = 0; i < 4; i++) {
            if (sortedNums[i+1] - sortedNums[i] != 1) {
                isContinuous = false;
                break;
            }
        }

        // 2. 숫자 중복 상태 파악 (가장 중요한 부분)
        int maxCount = 0;
        int topNum = 0, subNum = 0; // topNum: 가장 많이 겹치는 숫자, subNum: 두 번째로 겹치는 숫자

        for (int i = 1; i <= 9; i++) {
            if (numCount[i] >= maxCount) {
                subNum = topNum;
                topNum = i;
                maxCount = numCount[i];
            } else if (numCount[i] >= 2) {
                subNum = i;
            }
        }

        // 3. 우선순위에 따른 점수 계산
        int result = 0;

        if (isSameColor && isContinuous) { // 1번
            result = 900 + sortedNums[4];
        } else if (maxCount == 4) { // 2번
            result = 800 + topNum;
        } else if (maxCount == 3 && numCount[subNum] == 2) { // 3번 (Full House)
            result = 700 + topNum * 10 + subNum;
        } else if (isSameColor) { // 4번
            result = 600 + sortedNums[4];
        } else if (isContinuous) { // 5번
            result = 500 + sortedNums[4];
        } else if (maxCount == 3) { // 6번
            result = 400 + topNum;
        } else if (maxCount == 2 && numCount[subNum] == 2) { // 7번 (Two Pair)
            // Two Pair는 두 숫자 중 큰 숫자가 topNum이 되도록 보장해야 함
            int big = Math.max(topNum, subNum);
            int small = Math.min(topNum, subNum);
            result = 300 + big * 10 + small;
        } else if (maxCount == 2) { // 8번 (One Pair)
            result = 200 + topNum;
        } else { // 9번
            result = 100 + sortedNums[4];
        }

        System.out.println(result);
    }
}