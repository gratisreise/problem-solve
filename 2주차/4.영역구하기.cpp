#include<bits/stdc++.h>
using namespace std;
int m, n, k, sy, sx, ey, ex, cnt;
int a[101][101]; bool visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<int> ret;
void dfs(int y, int x){
    visited[y][x] = 1;
    cnt++;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= m || nx >= n)continue;
        if(a[ny][nx] != 1 && visited[ny][nx] == 0){
            dfs(ny, nx); 
        }
    }
}
// int dfs(int y, int x){ int형 재귀한번 그림그리기
//     visited[y][x] = 1;
//     int ret = 1;
//     for(int i = 0; i < 4; i++){
//         int ny = y + dy[i];
//         int nx = x + dx[i];
//         if(ny < 0 || ny >= m || nx < 0 || nx >= n || visited[ny][nx] == 1) continue;
//         if(a[ny][nx] == 1) continue;
//         ret += dfs(ny, nx);
//     }
//     return ret;
int main(){
    cin >> m >> n >> k;
    while(k--){
        cin >> sx >> sy >> ex >> ey;
        for(int x = sx; x < ex; x++){
            for(int y = sy; y < ey; y++){
                a[y][x] = 1;
            }
        }
    }
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(a[i][j] != 1 && visited[i][j] == 0){
                dfs(i, j); 
                if(cnt) ret.push_back(cnt); 
                cnt = 0;
            }
        }
    }
    sort(ret.begin(), ret.end());
    cout << ret.size() << '\n';
    for(int i : ret) cout << i << ' ';
    cout << '\n';
return 0;
}
/*
1. 1로 채우고 탐색조건에서 그냥 제외시켜 버리자
*/

