import java.util.*;

public class Main {
    static int n, ret, cnt = 1;
    static List<Pair> l = new ArrayList<>();
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
            int a = sc.nextInt();
            int b = sc.nextInt();
            l.add(new Pair(b, a));
        }

        Collections.sort(l, (a,b)->{
           if(a.f == b.f) return a.s - b.s;
           return a.f - b.f;
        });

        ret = l.get(0).f;

        for(int i = 1; i < n; i++){
            if(l.get(i).s < ret) continue;
            ret = l.get(i).f; cnt++;
        }

        System.out.println(cnt);
    }
}