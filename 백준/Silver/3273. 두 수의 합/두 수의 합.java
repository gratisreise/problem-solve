import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(a);
        int ret = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            if (a[l] + a[r] < x) l++;
            else if (a[l] + a[r] > x) r--;
            else {
                r--;
                ret++;
            }
        }
        bw.write(String.valueOf(ret) + '\n');
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
두수의 합이 조건에 맞는지 구하는법
아이디어: 양 끝점을 포인터로 잡고 조건에 따라 이동시키면서 확인한다.
1. 두 수의 합이 작으면 시작점을 올린다.
2. 두 수의 합이 크면 끝점을 내린다.
3. 두 수의 합이 x이면 ret++;하고 끝점을 내린다. 
*/
