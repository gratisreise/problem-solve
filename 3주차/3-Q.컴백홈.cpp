#include <bits/stdc++.h>
using namespace std;
int n, m, k, visited[10][10];
char a[10][10];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int go(int y, int x){ // int형 탐색으로 타고 올라가면서 ++
    if(y == 0 && x == m - 1){ //기저사례
        if(k == visited[y][x]) return 1; // 방문배열기준으로 k이면 리턴1
        return 0;
    }
    int ret = 0; 
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(visited[ny][nx] || a[ny][nx] == 'T') continue;
        visited[ny][nx] = visited[y][x] + 1;
        ret += go(ny, nx);
        visited[ny][nx] = 0; // 원복-> 0해줘서 다음 경우가 지나갈 수 있게
    }
    return ret;
}

int main(){
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++){
        cin >> s;
        for(int j = 0; j < m; j++){
            a[i][j] = s[j];
        }
    }
    visited[n - 1][0] = 1; //들어가기전 미리 색칠
    cout << go(n - 1, 0) << '\n'; // 호출
}