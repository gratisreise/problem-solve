class Solution {
    static int n;
    static int[][] vis;
    static void filled(int y, int x){
        for(int i = y - 1; i <= y + 1; i++){
            for(int j = x - 1; j <= x + 1; j++){
                if(i < 0 || j < 0 || i >= n || j >= n) continue;
                
                vis[i][j] = 1;
            }
        }
    }
    
    public int solution(int[][] a) {
        int ret = 0;
        n = a.length;
        vis = new int[n][n];
        System.out.println(n);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(a[i][j] == 1) filled(i, j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(vis[i][j] == 0) ret++;
            }
        }
        return ret;
    }
}