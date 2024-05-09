import java.io.*;
import java.util.*;

public class Main{
    static int[] psum = new int[100004];
    static int ret = -(int)1e9;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())
                ;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int temp = Integer.parseInt(st.nextToken());
            psum[i] = psum[i - 1] + temp;
        }
        for(int i = k; i <= n; i++){
            ret = Math.max(ret, psum[i] - psum[i - k]);
        }

        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
    }
}

/*
연속적인 날짜의 합-> 구간의 합
구간합 -> 누적합 배열을 이용해서 구한다.
1. 날짜 수 n과 연속날짜 k 입력받기
2. psum 누적합배열 만들기
3. 구간k만큼 순회하면서 최대값구하기
 */