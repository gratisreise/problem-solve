#include<bits/stdc++.h>
using namespace std;
int n, m, k, visited[10][10];
char a[10][10];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int go(int y, int x){
    if(y == 0 && x == m - 1){
        if(k == visited[y][x]) return 1;
        return 0;
    }
    int ret = 0;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] == 'T' || visited[ny][nx]) continue;
        visited[ny][nx] = visited[y][x] + 1;
        ret += go(ny, nx);
        visited[ny][nx] = 0;
    }
    return ret;
}
int main(){
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
        }
    }
    
    visited[n - 1][0] = 1;
    cout << go(n - 1, 0) << '\n';
}