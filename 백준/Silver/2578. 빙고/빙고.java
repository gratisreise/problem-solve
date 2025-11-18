import java.io.*;
import java.util.*;

public class Main {
    static int[][] nums;
    static boolean[][] check;
    static boolean isBingo(List<Integer> pos){
        int y = pos.get(0);
        int x = pos.get(1);
        check[y][x] = true;

        int cnt = 0;
        //대각선 빙고체크
        cnt += degag();

        //가로세로 빙고체크
        for(int i= 0; i < 5; i++){
            boolean flag1 = false;
            boolean flag2 = false;
            for(int j = 0; j < 5;j++){
                if(!check[i][j]) flag1 = true;
                if(!check[j][i]) flag2 = true;
            }
            if(!flag1) cnt++;
            if(!flag2) cnt++;
        }
        return cnt >= 3;
    }

    static int degag(){
        int sx = 0; int sy = 0;
        boolean flag = false;
        int ret = 0;
        //왼오 -> 오아
        while(sx < 5 && sy < 5){
            if(!check[sy][sx]) {
                flag = true;
                break;
            }
            sy++; sx++;
        }
        if(!flag) ret++;
        sy = 0; sx = 4;
        // 오위 -> 왼아
        flag = false;
        while(sy < 5 && sx >= 0){
            if(!check[sy][sx]){
                flag = true;
                break;
            }
            sy++; sx--;
        }
        if(!flag) ret++;
        return ret;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);


        nums = new int[5][5];
        check = new boolean[5][5];
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for(int i = 0; i < 5; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                nums[i][j] = num;
                pos.put(num, List.of(i, j));
            }
        }

        int ret = 0;
        boolean flag = false;
        for(int i = 0; i < 5; i++){
            var st = new StringTokenizer(in.readLine());
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                if(flag) continue;
                ret++;
                if(isBingo(pos.get(num))) flag = true;
            }
        }

        System.out.println(ret);

        out.flush();
        out.close();
    }
}