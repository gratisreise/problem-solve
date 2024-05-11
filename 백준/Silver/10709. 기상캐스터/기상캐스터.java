import java.io.*;
import java.util.*;

public class Main{

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n + 4][m + 4];

        for(int i = 0; i < n; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                if(c[j] == 'c') a[i][j] = 0;
                else a[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0){
                    int cnt = 1;
                    while(a[i][j + 1] == -1){
                        a[i][j + 1] = cnt++;
                        j++;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(a[i][j] + " ");
            }
            bw.write('\n');
        }
        bw.flush();
    }
}
/*
가로세로 1킬로미터인 작은 구역으로 나뉘어진다.
지금부터 몇 분뒤 처음으로 하늘에 구름이 오나?

0.-1로 채워진 배열에 현재 구름 있는 곳은 0으로 만들기
1.2차원 배열 순회
2. 0이면 해당 좌표 기준으로 j++하면서 숫자 넣어주기
3. 2차원 배열 출력
 */