// 이거 코드 어디 감 ㅋㅋㅋㅋㅋ
#include<bits/stdc++.h>
using namespace std;
int n, ret = 1;
int a[104][104], visited[104][104];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
void dfs(int y, int x, int d){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(a[ny][nx] <= d  || visited[ny][nx]) continue;
        dfs(ny, nx, d);
    }
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    for(int d = 0; d <= 100; d++){
        fill(&visited[0][0], &visited[0][0] + 104 * 104, 0);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] > d && visited[i][j] == 0){
                    dfs(i, j, d); cnt++;
                }
            }
        }
        ret = max(ret, cnt);
    }
    cout << ret << '\n';
    
}