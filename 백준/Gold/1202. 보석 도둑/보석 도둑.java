import java.io.*;
import java.util.*;

public class Main{
    static int n, k;
    static long ret;

    static class Pair{
        long m, v;
        Pair(long m, long v){
            this.m = m;
            this.v = v;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Pair> l = new ArrayList<>();
        List<Long> g = new ArrayList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            l.add(new Pair(a, b));
        }
        for(int i = 0; i < k; i++){
            long num = Long.parseLong(br.readLine());
            g.add(num);
        }

        Collections.sort(l, (a, b) -> Long.compare(a.m, b.m));
        Collections.sort(g);

        for(int i = 0, j = 0; i < k; i++){
            while(j < n && l.get(j).m <= g.get(i)){
                pq.add(l.get(j).v);
                j++;
            }
            if(!pq.isEmpty()) ret += pq.poll();
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
아이디어:
가방을 무게순으로 오름차로 배열하고 내림차 우선순위큐에 가격을 담는다
해당 무게에 해당하는 가격 중 가장비싼 가격을 ret에 더한다.
*/
