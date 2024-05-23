import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());  

        for (int t = 0; t < T; t++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String P = br.readLine();  // 명령어
            int N = Integer.parseInt(br.readLine());  // 숫자 개수
            String order = br.readLine();  // 배열 형태의 숫자 입력

            // 숫자 파싱
            int x = 0;
            for (char c : order.toCharArray()) {
                if (c == '[' || c == ']') continue;
                if (c >= '0' && c <= '9') x = x * 10 + c - '0';
                else {
                    if (x > 0) deque.addLast(x);
                    x = 0;
                }
            }
            if (x > 0) deque.addLast(x);

            // 초기에는 에러 없음, 뒤집히지 않은 상태
            boolean error = false, rev = false;
            for (char a : P.toCharArray()) {
                if (a == 'R') rev = !rev;
                else {
                    // 비어있는데 제거하려 하면 에러
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (rev) deque.pollLast();
                    else deque.pollFirst();
                }
            }

            // 에러가 발생한 경우
            if (error) bw.write("error\n");
            
            // 아닐 경우 덱의 원소를 하나하나 출력
            else {
                List<Integer> list = new ArrayList<>(deque);
                if (rev) Collections.reverse(list);

                bw.write("[");
                for (int i = 0; i < list.size(); i++) {
                    bw.write(String.valueOf(list.get(i)));
                    if (i < list.size() - 1) bw.write(",");
                }
                bw.write("]\n");
            }
        }

        // 출력 flush 및 close
        bw.flush();
        bw.close();
        br.close();
    }
}