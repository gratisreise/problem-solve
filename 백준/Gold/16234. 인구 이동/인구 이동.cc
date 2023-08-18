#include<bits/stdc++.h>
using namespace std;
int n, l, r, a[104][104], visited[104][104], sum, cnt;
vector<pair<int, int>> v;
const int dy[] = {0, 1, 0, -1};
const int dx[] = {1, 0, -1, 0};
void dfs(int y, int x){
    visited[y][x] = 1;
    sum += a[y][x];
    v.push_back({y,x});
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx]) continue;
        if(l <= abs(a[ny][nx] - a[y][x]) && abs(a[ny][nx] - a[y][x]) <= r){
            dfs(ny, nx);
        }
    }
}
int main(){
    cin >> n >> l >> r;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    while(true){
        bool flag = 0;
        memset(visited, 0, sizeof(visited));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                v.clear();
                sum = 0;
                if(!visited[i][j]) dfs(i, j);
                if(v.size() == 1) continue;
                for(auto b : v) {
                    a[b.first][b.second] = sum / v.size();
                    flag = 1;
                }
            }
        }
        if(!flag) break;
        cnt++;
    }
    cout << cnt << '\n';
}