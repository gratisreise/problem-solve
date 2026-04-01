import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        var st = new StringTokenizer(in.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[][] board = new char[h][w];
        int[][] ret = new int[h][w];
        for(int i = 0; i < h; i++){
            board[i] = in.readLine().toCharArray();
        }

        // -1초기화
        for(int i = 0; i < h; i++){
            Arrays.fill(ret[i], -1);
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(board[i][j] != 'c') continue;
                int temp = j+1;
                int cnt = 1;
                ret[i][j] = 0;
                while(temp < w && board[i][temp] != 'c'){
                    ret[i][temp++] = cnt++;
                }
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                out.print(ret[i][j] + " ");
            }
            out.println();
        }

        out.flush();
        out.close();
    }
}
/*
H:행 100 , W:열 100
1분에 한칸 동쪽으로, 몇분뒤에 처음으로 구름이 오는지 예측
c:구름, .:텅빈하늘
출력: 처음 구름: 0, 오지않으면 -1
-1로 채워진 배열에서 하늘 상태가 표현된 보드배열을 순회하면서
구름이 있으면 해당 구름의 이동을 움직이기 => 끝도달, 다른 구름 도달 멈춤, 그 인덱스 적용
보드배열, 정답배열,
출력 => 돌면서 print로 출력


*/