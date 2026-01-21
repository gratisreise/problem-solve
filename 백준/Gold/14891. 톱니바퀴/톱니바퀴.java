import java.io.*;
import java.util.*;

public class Main {
    static int[][] tobni = new int[4][8];
    static int[] dirs =  new int[4];

    static void makeDirs(int idx, int dir){
        int i = idx - 1;
        dirs = new int[4];
        dirs[i] = dir;
        int k = i+1;
        while(k < 4){
            if(tobni[k-1][2] != tobni[k][6]){
                dirs[k] = dirs[k-1] * -1;
                k++;
            } else break;
        }
        k = i-1;
        while(k >= 0){
            if(tobni[k][2] != tobni[k+1][6]){
                dirs[k] = dirs[k+1] * -1;
                k--;
            } else break;
        }
    }

    static void rotate(){
        for(int i = 0; i <4; i++){
            if(dirs[i] == 1){//시계
                rotateD(i);
            } else if(dirs[i] == -1){ //반시계
                rotateL(i);
            }
        }
    }
    static void rotateD(int idx){
        int[] temp = new int[8];
        for(int i =  0; i < temp.length; i++){
            temp[(i+1)%8] = tobni[idx][i];
        }
        tobni[idx] = temp;
    }
    static void rotateL(int idx){
        int[] temp = new int[8];
        for(int i =  0; i < temp.length; i++){
            temp[(i+7)%8] = tobni[idx][i];
        }
        tobni[idx] = temp;
    }

    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        for(int i = 0; i < 4; i++){
            String line = in.readLine();
            for(int j=  0; j < 8; j++){
                tobni[i][j] = line.charAt(j) - '0';
            }
        }

        int n = Integer.parseInt(in.readLine());
        for(int i = 0; i < n; i++){
            var st = new StringTokenizer(in.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            //회전 여부 찾기
            makeDirs(idx, dir);
            //회전
            rotate();
        }

        int ret = 0;
        for(int i = 0, j = 1; i < 4; i++, j *= 2){
            if(tobni[i][0] == 1) ret += j;
        }
        out.println(ret);

        out.flush();
        out.close();
    }
}
/*
각 회전마다 회전상태를 배열로 정의 회전하지 않으면
while로 위아래 처버리면 가능할듯
1. 입력을 받는다
2. 회전 지점 기준으로 위아래 회전가능 체크 후 회전배열 반환
3. 회전 후 저장

*/