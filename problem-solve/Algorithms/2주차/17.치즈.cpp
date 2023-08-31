#include<bits/stdc++.h>
using namespace std;
int n, m, cnt, cnt2, a[104][104], visited[104][104];
const int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
vector<pair<int, int>> v;
void go(int y, int x){
    visited[y][x] = 1;
    if(a[y][x] == 1){v.push_back({y, x}); return;}
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
        go(ny, nx);
    }
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0 ; j < m; j++){
            cin >> a[i][j];
        }
    }
    while(1){
        cnt2 = 0;
        memset(visited, 0, sizeof(visited));
        v.clear();
        go(0, 0);
        // 마지막은 녹이는 수가 치즈 갯수
        for(auto i : v){
            cnt2++;
            a[i.first][i.second] = 0;
        }
        bool flag = 0;
        // 치즈있나 체크
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != 0) flag = 1;
            }
        }
        cnt++; // 시간체크
        if(!flag) break;
    }
    cout << cnt << '\n' << cnt2 << '\n';
}

#include<bits/stdc++.h>
using namespace std;
#define prev noah
int n, m, ret, a[104][104], visited[104][104], prev;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
        if(a[ny][nx]){visited[ny][nx] = 1; a[ny][nx] = 0; continue;}
        dfs(ny, nx);
    }
}
int main(){
    cin >> n >> m;
    int cnt = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
        }
    }
    while(1){
        memset(visited, 0, sizeof(visited));
        dfs(0, 0);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j]) cnt++;
            }
        }
        ret++;
        if(cnt == 0) break; 
        prev = cnt;
    } 
    cout << ret << '\n' << prev << '\n';
}

/*
1. dfs를 들어갈 때 a[i][j]가 1이면 칠하고 0으로 바꾸고
치즈를 만나면 치즈의 좌표를 저장했다가 나중에 녹여주는 로직으로 수행
*/