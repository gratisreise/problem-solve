#include<bits/stdc++.h>
using namespace std;
int n, m, cnt, cnt2, a[104][104], visited[104][104];
int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
vector<pair<int, int>> v;
void dfs(int y, int x){
    visited[y][x] = 1;
    if(a[y][x] == 1) {v.push_back({y, x}); return;}
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx]) continue;
        dfs(ny, nx);
    }
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
        }
    }
    while(true){
        memset(visited, 0, sizeof(visited));
        v.clear();
        cnt2 = 0; // 치지 갯수
        dfs(0, 0);
        for(auto b : v) cnt2++, a[b.first][b.second] = 0;
        bool flag = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != 0) flag = 1;
            }
        }
        cnt++; //시간
        if(!flag) break;
    }
    cout << cnt << '\n' << cnt2 << '\n';
}