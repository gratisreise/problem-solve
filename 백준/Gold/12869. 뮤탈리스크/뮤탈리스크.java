import java.util.*;

public class Main{
    static int n;
    static int[] a = new int[3];
    static int[][][] visited = new int[65][65][65];
    static class A{
        int a, b, c;
        A(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static int[][] _a = new int[][]{
            {9, 3, 1}, {9, 1, 3},
            {3, 1, 9}, {3, 9, 1},
            {1, 3, 9}, {1, 9, 3}
    };
    static Queue<A> q = new LinkedList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++) a[i] = sc.nextInt();
        q.add(new A(a[0], a[1], a[2]));
        visited[a[0]][a[1]][a[2]] = 1;
        while(!q.isEmpty()){
            A p = q.poll();
            int a = p.a;
            int b = p.b;
            int c = p.c;
            if(visited[0][0][0] != 0) break;
            for(int i = 0; i < 6; i++){
                int na = Math.max(0, a - _a[i][0]);
                int nb = Math.max(0, b - _a[i][1]);
                int nc = Math.max(0, c - _a[i][2]);
                if(visited[na][nb][nc] != 0) continue;
                visited[na][nb][nc] = visited[a][b][c] + 1;
                q.add(new A(na, nb, nc));
            }
        }
        System.out.println(visited[0][0][0] - 1);
    }
}