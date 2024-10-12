import java.util.*;
class Solution {
    class Pair{
        String f; int s;
        Pair(String f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static List<Pair> l = new ArrayList<>();
    static List<String> ret = new ArrayList<>();
    public List<String> solution(String[] strings, int n) {
        for(String s : strings) l.add(new Pair(s, (int)s.charAt(n)));
        Collections.sort(l, (a, b) ->{
            if(a.s == b.s){
                return a.f.compareTo(b.f);
            } return a.s - b.s;
        });
        for(Pair p : l) ret.add(p.f);
            
        
        return ret;
    }
}