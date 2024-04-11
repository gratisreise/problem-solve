class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[] d = {'N', 'S', 'W', 'E'};
    static int[] ret = new int[2];
    static int n, m, sy, sx;
    static char[][] park1;
    static void go(int y, int x, char dir, int size){
        for(int i = 0; i < 4; i++){
            if(d[i] != dir) continue;
            int ny = y + dy[i] * size;
            int nx = x + dx[i] * size;
            // System.out.println(ny + " :: "+ nx);
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) return;
            int k = 0;
            while(k < size){
                k++;
                int yy = y + dy[i]*k;
                int xx = x + dx[i]*k;
                if(yy < 0 || xx < 0 || y >= n || x >= m) return;
                if(park1[yy][xx] == 'X') return;
            }
            ret[0] = ny;
            ret[1] = nx;
        }
        return;
    }
    public int[] solution(String[] park, String[] routes) {
        n = park.length;
        m = park[0].length();
        park1 = new char[n][m];
        for(int i = 0; i < n; i++){
            park1[i] = park[i].toCharArray();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(park1[i][j] == 'S'){
                    sy = i; sx = j;
                }
            }
        }
        ret[0] = sy;
        ret[1] = sx;
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(park1[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(String s : routes){
            char dir = s.charAt(0);
            int size = s.charAt(2) - '0';
            // System.out.println(dir + " :: "+ size);
            go(ret[0], ret[1], dir, size);
        }
        return ret;
    }
}