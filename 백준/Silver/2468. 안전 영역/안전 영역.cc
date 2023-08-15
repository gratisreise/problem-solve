#include<bits/stdc++.h>
using namespace std;
int n, cnt, ret = 1;
int a[101][101], visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int y, int x, int k){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(a[ny][nx] > k && !visited[ny][nx]) dfs(ny, nx, k);
    }
    return;
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    for(int k = 1; k < 101; k++){
        fill(&visited[0][0], &visited[0][0] + 101 * 101, 0);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] > k && !visited[i][j]){
                    dfs(i, j, k); cnt++;
                }
            }
        }
        ret = max(ret, cnt);
    }
    cout << ret << '\n';
}