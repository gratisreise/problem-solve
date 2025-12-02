import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가로
        int m = Integer.parseInt(st.nextToken()); // 세로
        int k = Integer.parseInt(in.readLine());
        List<Integer> pointR = new ArrayList<>();
        List<Integer> pointC = new ArrayList<>();
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(in.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(dir == 1)pointR.add(num);
            else pointC.add(num);
        }
        pointR.sort(Integer::compareTo);
        pointC.sort(Integer::compareTo);
        int retG = 0;
        int retS = 0;
        if(pointR.isEmpty()){
            retG = n;
        } else {
            int prev = 0;
            for(int i : pointR){
                retG = Math.max(retG, i - prev);
                prev = i;
            }
            retG = Math.max(retG, n - prev);
        }
        if(pointC.isEmpty()){
            retS = m;
        } else {
            int prev = 0;
            for(int i : pointC){
                retS = Math.max(retS, i - prev);
                prev = i;
            }
            retS = Math.max(retS, m - prev);
        }
        System.out.println(retS * retG);
        out.flush();
        out.close();
    }
}
/*
가로 0
세로 1

자르기 어떻게 처리하지??
아이디어:
크기 2배 처리
4만 이면 낫배드 int

만약 가로만 주어지면?
세로만 주어지면??
아예없으면??



*/