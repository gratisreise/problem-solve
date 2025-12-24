import java.io.*;
import java.util.*;

public class Main {
    static class Pos{
        int y; int  x;
        Pos(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static int[][] board = new int[7][7];
    static int[] dy = {2, 2, 1, -1, -2, -2, 1, -1};
    static int[] dx = {1, -1, 2, 2, 1, -1, -2, -2};

    static boolean check(Pos prev, Pos now){
        int prevY = prev.y;
        int prevX = prev.x;
        int nowY = now.y;
        int nowX = now.x;
        for(int d = 0; d < 8; d++){
            int ny = prevY + dy[d];
            int nx = prevX + dx[d];
            if(ny < 0 || nx < 0 || ny > 6 || nx > 6) continue;
            if(board[ny][nx] != 0) continue;
            if(ny == nowY && nx == nowX){
                board[ny][nx] = 1;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);


        Map<String, Integer> mp = new HashMap<>();
        for(int i = 'A'; i <= 'F'; i++){
            char c = (char)i;
            mp.put(""+c, i-'A'+1);
        }
        List<Pos> poss = new ArrayList<>();
        for(int i = 0; i < 36; i++){
            String[] srr = in.readLine().split("");
            int y = Integer.parseInt(srr[1]);
            int x = mp.get(srr[0]);
            poss.add(new Pos(y, x));
        }


        Pos prev = poss.get(0);

        for(int i = 1; i < 36; i++){
            Pos now = poss.get(i);
            if(!check(prev , now)){
                System.out.println("Invalid");
                return;
            }
            prev = now;
        }

        if(!check(prev, poss.get(0))){
            System.out.println("Invalid");
        } else {
            System.out.println("Valid");
        }
        out.flush();
        out.close();
    }
}