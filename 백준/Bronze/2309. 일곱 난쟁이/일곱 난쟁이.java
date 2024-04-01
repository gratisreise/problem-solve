import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] a = new int[9];
        int sum = 0;

        // 입력
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }

        int num1 = 0;
        int num2 = 0;

        // 두 난쟁이의 키의 합이 100이 되는 경우 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - a[i] - a[j] == 100) {
                    num1 = i;
                    num2 = j;
                    break;
                }
            }
        }

        List<Integer> l = new ArrayList<>();

        // 결과 리스트에 추가
        for (int i = 0; i < 9; i++) {
            if (i == num1 || i == num2) continue;
            l.add(a[i]);
        }

        // 정렬
        Collections.sort(l);

        // 출력
        for (int i : l) System.out.println(i);
    }
}
