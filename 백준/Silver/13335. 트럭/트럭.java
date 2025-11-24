import java.io.*;
import java.util.*;

public class Main {
    static class Truck{
        int w;
        int t;
        Truck(int w, int t){
            this.w = w;
            this.t = t;
        }

        @Override
        public String toString(){
            return this.w + " : "+ this.t;
        }
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Queue<Integer> weight = new LinkedList<>();
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < n; i++){
            weight.add(Integer.parseInt(st.nextToken()));
        }
        PriorityQueue<Truck> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.t));
        int ret = 0;
        int curL = 0;
        while(!weight.isEmpty() || !pq.isEmpty()){
            ret++;
            //떠나는 트럭 체크
            if(!pq.isEmpty()){
                Truck curT = pq.peek();
                int time = curT.t;
                if(ret - time == w){
                    pq.poll();
                    curL -= curT.w;
                }
            }
            //넣어주는 트럭체크
            if(!weight.isEmpty()){
                int ww = weight.peek();
                //크기가능 무게넘지않음
                if(pq.size() < w && curL + ww <= l){
                    pq.add(new Truck(ww, ret));
                    curL += ww;
                    weight.poll();
                }
            }
        }
        System.out.println(ret);



        out.flush();
        out.close();
    }
}