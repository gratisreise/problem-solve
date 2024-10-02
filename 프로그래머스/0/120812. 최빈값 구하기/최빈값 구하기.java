import java.util.*;
class Solution {
    class Pair{
        int a, b;
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    public int solution(int[] array) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Pair> l = new ArrayList<>();
        for(int i : array) mp.put(i, mp.getOrDefault(i, 0) + 1);
        for(int i : mp.keySet()) l.add(new Pair(i, mp.get(i)));
        Collections.sort(l, (a, b) -> Integer.compare(b.b, a.b));
        if(l.size() >= 2 && l.get(0).b == l.get(1).b) return -1;
        return l.get(0).a;
    }
}