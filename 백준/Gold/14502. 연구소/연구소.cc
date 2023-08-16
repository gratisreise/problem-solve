#include<bits/stdc++.h>
using namespace std;
int n, m, a[10][10], visited[10][10], ret = -1;
vector<pair<int, int>> vir, wall;
const int dy[] = {0, 1, 0, -1};
const int dx[] = {-1, 0, 1, 0};
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i ++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] == 1 || visited[ny][nx]) continue;
        dfs(ny, nx);
    }
}
void solve(){
    int cnt = 0;
    memset(visited, 0, sizeof(visited));
    for(auto v : vir) dfs(v.first, v.second);
    for(auto w : wall){
        if(a[w.first][w.second] == 0 && visited[w.first][w.second] == 0){
            cnt++;
        }
    }
    ret = max(ret, cnt);
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] == 2) vir.push_back({i, j});
            if(a[i][j] == 0) wall.push_back({i, j});
        }
    }
    for(int i = 0; i <  wall.size(); i++){
        for(int j = 0; j < i; j++){
            for(int k = 0; k < j; k++){
                a[wall[i].first][wall[i].second] = 1;
                a[wall[j].first][wall[j].second] = 1;
                a[wall[k].first][wall[k].second] = 1;
                solve();
                a[wall[i].first][wall[i].second] = 0;
                a[wall[j].first][wall[j].second] = 0;
                a[wall[k].first][wall[k].second] = 0;
            }
        }
    }
    cout << ret << '\n';
}