import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int[] left(int[] row){
        int n = 20;
        int[] temp = new int[n];
        for(int i = 0; i < n-1; i++){
            int now = row[(i+1)%n];
            temp[i] = now;
        }
        return temp;
    }
    static int[] right(int[] row){
        int n = 20;
        int[] temp = new int[n];
        for(int i = 1; i < n; i++){
            int now = row[(i+19)%n];
            temp[i] = now;
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] trains = new int[n+1][20];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(in.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train =  Integer.parseInt(st.nextToken());
            if(cmd == 1){
                int seat = Integer.parseInt(st.nextToken())-1;
                trains[train][seat] = 1;
            } else if(cmd == 2){
                int seat = Integer.parseInt(st.nextToken())-1;
                trains[train][seat] = 0;
            } else if(cmd == 3){
                trains[train] = right(trains[train]);
            } else{
                trains[train] = left(trains[train]);
            }
        }

        Set<List<Integer>> set = new HashSet<>();
        for(int i = 1; i <= n; i++){
            List<Integer> l = new ArrayList<>();
            for(int num : trains[i]) l.add(num);
            set.add(l);
        }
        System.out.println(set.size());

        out.flush();
        out.close();
    }
}
/*
1 i x: i번기차 x번좌석에 승차
2 i x: i번기차 x번좌석에 하차
3 i: i번 오른쪽 회전
4 i: i번 왼쪽회전
똑같은 형태는 지나가 수 없음
은하수 지나는 기차의 수
n[1,10만] m[1,10만]
2^20 조합
20 * 10만 = 200만 가능
2차원 배열로 진행, 오른쪽회전 왼쪽회전 함수 구현
1. 입력받으면서 명령어 진행
2.

0 1 2 3
1 2 3 4


1 3
1 1 1
1 1 2
3 1


*/