import java.io.*;
import java.util.*;

public class Main {
    static int toDays(String[] time1, String[] time2){
        int[] start = new int[3];
        int[] end = new int[3];
        for(int i = 0; i < 3; i++){
            start[i] = Integer.parseInt(time1[i]);
            end[i] = Integer.parseInt(time2[i]);
        }

        if(end[0] - start[0] > 1000) return -1;
        if (end[0] - start[0] == 1000) {
            if(end[1] - start[1] > 0){
                return -1;
            } else if(end[1] - start[1] == 0){
                if(end[2] - start[2] >= 0) return -1;
            }
        }
        return toDays(end) - toDays(start);
    }
    static int toDays(int[] time){
        int ret = 0;
        int one = 365;
        int another = 366;
        for(int i = 1; i < time[0]; i++){
            if(isYoon(i)) ret += another;
            else ret += one;
        }
        int thisYear = time[0];
        Set<Integer> d31 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 8, 10, 12));
        for(int i = 1; i < time[1]; i++){
            if(i == 2){
                if(isYoon(thisYear)) ret += 29;
                else ret += 28;
            } else {
                if(d31.contains(i)) ret += 31;
                else ret += 30;
            }
        }
        ret += time[2];
        return ret;
    }
    static boolean isYoon(int num){
        if(num % 400 == 0) return true;
        else if(num % 100 == 0) return false;
        else if(num % 4 == 0) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        String[] start = in.readLine().split(" ");
        String[] end = in.readLine().split(" ");

        int s = toDays(start, end);
        if(s == -1){
            out.println("gg");
        } else{
            out.printf("D-%d", s);
        }


        out.flush();
        out.close();
    }
}
/*
day로 바꿔서 서로 뺀다음 보여주기
1000년보다 더걸리면 gg

1. 1000년인지 확인
2. day로 변환
3. 서로 빼서 D-N 으로 출력
2008 12 27
3008 12 27
*/