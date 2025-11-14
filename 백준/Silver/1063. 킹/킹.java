import java.io.*;
import java.util.*;

public class Main {
    static class Dir{
        int y; int x;
        public Dir(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
    static boolean boundary(int y, int x){
        return y < 0 || x < 0 || y >= 8 || x >= 8;
    }
    public static void main(String[] args) throws IOException {
        var in = new BufferedReader(new InputStreamReader(System.in));
        var out = new PrintWriter(System.out);

        Map<String, Dir> dir = new HashMap<>();
        dir.put("R", new Dir(0, 1));
        dir.put("L", new Dir(0, -1));
        dir.put("B", new Dir(-1, 0));
        dir.put("T", new Dir(1, 0));
        dir.put("RT", new Dir(1, 1));
        dir.put("LT", new Dir(1, -1));
        dir.put("RB", new Dir(-1, 1));
        dir.put("LB", new Dir(-1, -1));

        Map<String, Integer> alpToNum = new HashMap<>();
        Map<Integer, String> numToAlp = new HashMap<>();

        for(int i = 'A'; i <= 'H'; i++){
            String alp = "" + (char)i;
            int num = i - 'A';
            alpToNum.put(alp, num);
            numToAlp.put(num, alp);
        }

        int[][] board = new int[8][8];

        String[] sr = in.readLine().split(" ");
        String[] king = sr[0].split("");
        String[] stone = sr[1].split("");
        int n = Integer.parseInt(sr[2]);
        int ky = Integer.parseInt(king[1])-1;
        int kx = alpToNum.get(king[0]);
        int sy = Integer.parseInt(stone[1])-1;;
        int sx = alpToNum.get(stone[0]);;

        for(int i = 0; i < n; i++){
            String cmd = in.readLine();
            Dir d = dir.get(cmd);
            int ny = ky + d.y;
            int nx = kx + d.x;
            if(boundary(ny, nx)) continue;
            if(ny == sy && nx == sx) { // 돌체크
                int sny = sy + d.y;
                int snx = sx + d.x;
                if (boundary(sny, snx)) continue;
                sy = sny;
                sx = snx;
            }
            ky = ny;
            kx = nx;
        }
        String King = numToAlp.get(kx) + (ky+1);
        String Stone = numToAlp.get(sx) + (sy+1);
        out.println(King + "\n" + Stone);

        out.flush();
        out.close();
    }
}