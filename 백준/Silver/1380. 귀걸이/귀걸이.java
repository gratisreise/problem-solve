import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int t = 0;
        while(true){
            t++;
            int n = Integer.parseInt(in.readLine());
            if(n == 0) break;
            String[] names = new String[n+1];
            int[] cnt = new int[n+1];
            for(int i = 0; i < n; i++){
                names[i+1] = in.readLine();
            }
            for(int i = 0; i < 2*n-1; i++) {
                var st = new StringTokenizer(in.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String a = st.nextToken();
                if(cnt[idx] == 0) cnt[idx]++;
                else cnt[idx]--;
            }

            for(int i = 1; i <= n; i++){
                if(cnt[i] > 0) {
                    out.printf("%d %s\n", t, names[i]);
                    break;
                }
            }
        }


        out.flush();
        out.close();
    }
}
/*
학생 - (AorB) + 번호
귀걸이 못받은 사람
n[1,100]
이름[1, 60]
번호 - 학생
다시체크될 때 "returned"
1. 학생입력받을 때 숫자 - 학생이름 배열 설정, cnt+1
2. 반환 확인 입력되어지는 숫자의 cnt배열로 확인
3. cnt배열 돌면서 못받은 학생의 이름 출력


1
Betty Boolean
1 B
0
Helen Clark
Margaret Thatcher
1 B
2 B
2 A
0
*/