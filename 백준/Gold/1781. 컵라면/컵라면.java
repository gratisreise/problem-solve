import java.io.*;
import java.util.*;
public class Main {
    static int n, c, d, ret;
    static class Pair{
        int d, c;
        Pair(int d, int c){
            this.d = d;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Pair> l = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l.add(new Pair(d, c)); // 날짜, 컵수
        }
        Collections.sort(l, (a, b) -> Integer.compare(a.d, b.d));
        for(int i = 0; i < l.size(); i++){
            ret += l.get(i).c;  // 컵수 더하기
            pq.add(l.get(i).c); // 컵 넣어서 day 세주기
            // 컵
            while(pq.size() > l.get(i).d){
                ret -= pq.poll();
            }
        }
        bw.write(String.valueOf(ret)+'\n');
        bw.flush();
        bw.close();
        br.close();
    }
}