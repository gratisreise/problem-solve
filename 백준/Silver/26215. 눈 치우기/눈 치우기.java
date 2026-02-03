import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        var nums = new PriorityQueue<Integer>((a,b) -> b - a);
        var st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++) nums.add(Integer.parseInt(st.nextToken()));
        if(nums.peek() > 1440){
            System.out.println(-1);
            return;
        }
        int time = 0;
        while(!nums.isEmpty()){
            if(nums.size() == 1){
                time += nums.peek();
                break;
            }
            int a = nums.poll();
            int b = nums.poll();
            a--; b--;
            if(a > 0) nums.add(a);
            if(b > 0) nums.add(b);
            time++;
        };

        out.println(time > 1440 ? -1 : time);

        out.flush();
        out.close();
    }
}
/*
1분에 한번씩 2집선택 둘다 -1 or 하나 -1
눈을 치우는 최소시간
1440넘으면 -1 출력
n[1,100],
exc: 1440 넘는 요소 있으면 끝,
아이디어: pq로 넣고 높은애들 2놈꺼내서 삭제하고 넣고 반복-> 마지막 하나만 남으면 현재시간에 더해주기
1. 2놈꺼내기(2개보다 큰지 체크)
2. 차감하고 집어넣기(0이면 넣지 않기)
3.

*/