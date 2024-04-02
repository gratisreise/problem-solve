import java.util.*;

public class Main {
    static int n, m, ret = Integer.MAX_VALUE;
    static int[][] a = new int[54][54];
    static class Pair{
        int f, s;
        Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }
    static void combi(int start, List<Integer> l){
        if(l.size() == m){
            chi_combi.add(new ArrayList<>(l));
            return;
        }
        for(int i = start + 1; i < Chi.size(); i++){
            l.add(i);
            combi(i, l);
            l.remove(l.indexOf(i));
        }
    }
    static List<Pair> home = new ArrayList<>();
    static List<Pair> Chi = new ArrayList<>();
    static List<List<Integer>> chi_combi = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                a[i][j] = sc.nextInt();
                if(a[i][j] == 1) home.add(new Pair(i, j));
                else if(a[i][j] == 2) Chi.add(new Pair(i,j));
            }
        }
        List<Integer> l = new ArrayList<>();
        combi(-1, l);
        for(List<Integer> C : chi_combi){
            int dis_sum = 0;
            for(Pair h : home){
                int min = Integer.MAX_VALUE;
                for(int c : C){
                    int dis =  Math.abs(h.f - Chi.get(c).f) + Math.abs(h.s - Chi.get(c).s);
                    min = Math.min(min, dis);
                }
                dis_sum += min;
            }
            ret = Math.min(dis_sum, ret);
        }
        System.out.println(ret);
    }
}