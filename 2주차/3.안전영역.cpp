#include<bits/stdc++.h>
using namespace std;
int n, y, x, ret = 1;
int a[101][101]; bool visited[101][101];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int y, int x, int d){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
        if(a[ny][nx] > d && visited[ny][nx] == 0){
            dfs(ny, nx, d);
        }
    }
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    for(int d = 1; d <= 100; d++){
        fill(&visited[0][0],&visited[0][0] + 101 * 101,0);
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
    
    return 0;
}
/*
1.탐색의 제한조건으로는 높이 정보 
2. 탐색 자체를 반복문으로 돌리기
3. 4방향 탐색
*/