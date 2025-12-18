import java.io.*;
import java.util.*;

public class Main {
    static class People{
        int score; int idx;
        People(int score, int idx){
            this.score = score;
            this.idx = idx;
        }
    }
    static int combi(int n, int r, int s, int[] arr, List<Integer> l){
        if(l.size() == r){
            int sum = 0;
            for(int i : l) sum += i;
            return sum % 10;
        }
        int ret = 0;
        for(int i = s; i < n; i++){
             l.add(arr[i]);
             ret = Math.max(combi(n, r, i+1, arr, l) ,ret);
             l.remove(l.size() - 1);
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());
        List<People> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int[] arr = new int[5];
            for(int j = 0; j < 5; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int score = combi(5, 3, 0, arr, new ArrayList<>());
            l.add(new People(score, i+1));
        }

        l.sort((a,b) -> {
            if(a.score == b.score){
                return b.idx - a.idx;
            } return b.score - a.score;
        });

        out.println(l.get(0).idx);


        out.flush();
        out.close();
    }
}