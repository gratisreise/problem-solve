#include<bits/stdc++.h>
using namespace std;
int t, k, n, m, y, x, a[54][54], visited[54][54];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] == 1 && visited[ny][nx] == 0){
            dfs(ny, nx);
        }
    }
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> t;
    while(t--){
        memset(a, 0, sizeof(a));
        memset(visited, 0, sizeof(visited));
        int ret = 0;
        cin >> m >> n >> k;
        while(k--){
            cin >> x >> y;
            a[y][x] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1 && visited[i][j] == 0){
                    dfs(i, j); ret++;
                }
            }
        }
        cout << ret << '\n';
    }
}