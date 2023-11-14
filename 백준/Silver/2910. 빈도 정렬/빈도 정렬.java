import java.util.*;
public class Main{
    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> mp1 = new HashMap<>(); //빈도
        Map<Integer, Integer> mp2 = new HashMap<>();//순서
        List<Pair> l = new ArrayList<>();
        int n = sc.nextInt();
        int c = sc.nextInt();
        for(int i = 0; i < n; i++){
            int temp = sc.nextInt();
             mp1.put(temp, mp1.getOrDefault(temp, 0) + 1);
             if(!mp2.containsKey(temp)){
                 mp2.put(temp, i + 1);
             }
        }
        for(Map.Entry<Integer, Integer> e : mp1.entrySet()){
            l.add(new Pair(e.getValue(), e.getKey()));
        }
        Collections.sort(l, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.f == b.f){
                    return mp2.get(a.s) - mp2.get(b.s); // 순서 오름차순
                }
                return b.f - a.f; //빈도 내림차순
            }
        });

        for(Pair p : l){
            for(int j = 0; j < p.f; j++){
                System.out.print(p.s + " ");
            }
        }
    }
}