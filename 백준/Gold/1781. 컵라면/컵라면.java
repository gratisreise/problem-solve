import java.util.*;

public class Main {
    static int n, c, d, ret;
    static List<Pair> l = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            d = sc.nextInt();
            c = sc.nextInt();
            l.add(new Pair(d, c)); // 날짜, 컵수
        }
        Collections.sort(l, (a, b) -> a.f - b.f);
        for(int i = 0; i < l.size(); i++){
            ret += l.get(i).s;
            pq.add(l.get(i).s);
            while(pq.size() > l.get(i).f){
                ret -= pq.poll();
            }
        }
        System.out.println(ret);
    }
}