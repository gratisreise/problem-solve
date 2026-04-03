import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    // 블루레이 크기가 mid일 때, m개 이하의 블루레이로 담을 수 있는지 확인
    static boolean check(long mid) {
        int cnt = 1; // 최소 1개는 사용
        long sum = 0;

        for (int i = 0; i < n; i++) {
            // 현재 블루레이에 이 강의를 더 담을 수 있는지 체크
            if (sum + arr[i] > mid) {
                cnt++;      // 새 블루레이 사용
                sum = arr[i]; // 새 블루레이에 현재 강의 담기
            } else {
                sum += arr[i];
            }
        }
        
        // 사용된 블루레이 개수가 m개 이하이면 true
        return cnt <= m;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        long l = 0; // 강의 중 최대값 (최소한 이보다는 커야 함)
        long r = 0; // 모든 강의의 총합 (하나에 다 담는 경우)
        
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            r += arr[i];
            l = Math.max(l, arr[i]); // 가장 긴 강의 시간을 l로 잡아야 함!
        }

        long answer = r; // 가능한 최댓값으로 초기화

        while (l <= r) {
            long mid = (l + r) / 2;
            
            if (check(mid)) {
                // m개 이하로 담을 수 있다면, "더 작은 크기"도 가능한지 탐색
                answer = mid; 
                r = mid - 1;
            } else {
                // m개 안에 못 담는다면, 크기를 "더 키워야" 함
                l = mid + 1;
            }
        }
        
        out.println(answer);
        out.flush();
        out.close();
    }
}