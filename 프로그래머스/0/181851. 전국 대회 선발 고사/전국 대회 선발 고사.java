import java.util.*;

class Solution {
    class Pair{
        int a, r; boolean b;
        Pair(int a, int r, boolean b){
            this.a = a;
            this.r = r;
            this.b = b;
        }
    }
    private int stuNumber(int a, int[] rank){
        for(int i = 0; i < rank.length; i++){
            if(a == rank[i]) return i;
        }
        return 0;
    }
    public int solution(int[] rank, boolean[] attendance) {
        List<Pair> l = new ArrayList<>();
        for(int i = 0; i < rank.length; i++){
            l.add(new Pair(rank[i], i, attendance[i]));
        }
        Collections.sort(l, (a, b)-> Integer.compare(a.a, b.a));
        int[] ret = new int[3];
        int idx = 0;
        for(Pair p : l){
            if(ret[2] != 0) break;
            if(p.b) ret[idx++] = p.r;
        }
        return (10000 * ret[0]) + (100 * ret[1]) + ret[2];
    }
}