import java.io.*;
import java.util.*;

public class Main{
    static int n, p, d, ret;
    static class Pair{
        int d, p;
        Pair(int d, int p){
            this.d = d;
            this.p = p;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Pair> l = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            l.add(new Pair(d, p));
        }
        
        Collections.sort(l, (a, b) -> Integer.compare(a.d, b.d));

        for(Pair p : l){
            ret += p.p;
            pq.add(p.p);
            while(pq.size() > p.d){
                ret -= pq.poll();
            }
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
1. 날짜 기준 오름차 정렬
2. 리스트에 저장
3. 리스트를 순회
    3-1. 오름차 pq에 가격을 저장
    3-2. ret에 가격 더하기
    3-2. pq의 크기가 날짜보다 큰지 확인
        3-2-1.크면
            날짜에 해당하는 값중 최대가 아닌게 있으므로 ret에 가격 빼기
        3-2-2.작거나같으면
            날짜에 해당하는 값중 최대값이다.
4. ret 출력!!
*/