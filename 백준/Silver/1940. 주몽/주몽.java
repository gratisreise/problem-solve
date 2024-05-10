import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] a = new int[n + 4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (m > 200000)  bw.write("0\n");
        else {
            int ret = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i] + a[j] == m) ret++;
                }
            }
            bw.write(String.valueOf(ret)+"\n");
        }
        bw.flush();
    }
}
/*
재료의 개수에서 2개를 선택해서 더했을 때 M이면 출력
1. M이 20만보다 크면 그냥 1 출력하고 끝
2. 아니면 2중 for문으로 조합을 돌린다.
3. 선택된 두수를 더해서 m이랑 맞느지 체크
4. 맞으면 ret++ 아니면 넘기기
 */