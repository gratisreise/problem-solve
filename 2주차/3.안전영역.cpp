// 이거 코드 어디 감 ㅋㅋㅋㅋㅋ
#include<bits/stdc++.h>
using namespace std;
int n, 
int a[104][104], visited[104][104];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
void dfs(int y, int x, int d){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] <= d 0 || visited[ny][nx]) continue;
        dfs(ny, nx, d);
    }
}
int main(){
    
}