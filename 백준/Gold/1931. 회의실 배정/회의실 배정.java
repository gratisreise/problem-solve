import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        var l = new ArrayList<int[]>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            l.add(new int[]{s, e});
        }
        l.sort((a, b) -> {
            if(a[1] == b[1]) return a[0] - b[1];
            return a[1] - b[1];
        });

        int ret = 0;
        int end = 0;
        for(int[] arr : l){
            if(arr[0] < end) continue;
            if(arr[0] >= end){
                end = arr[1];
                ret++;
            }
        }
        out.println(ret);



        out.flush();
        out.close();
    }
}
/*
회의실 한개, 시작, 끝,
겹치지 않으면서 회의실 사용최대 갯수
끝기 기준 정렬?? => 왜? 끝이 기준이면 빨리끝나는 놈들 부터 들어가겠다!!
1. 입력
2. 끝 기준 정렬
3. 순회하면서 들어가는 팀의 갯수 세기
*/