#include<bits/stdc++.h>
using namespace std;

// 상, 우, 하, 좌 방향으로 이동하는 dy, dx 배열 선언
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
int n, m, k, visited[10][10]; // n: 행의 개수, m: 열의 개수, k: 거리, visited: 방문 여부를 체크하는 2차원 배열
char a[10][10]; // 경로를 나타내는 2차원 배열

int go(int y, int x){
    if(y == 0 && x == m - 1){ // 현재 위치가 집의 위치(0, m-1)일 경우, 거리가 k인 경우의 수를 반환
        if(k == visited[y][x]) return 1;
        return 0;
    }
    int ret = 0;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        // 경계를 벗어나거나 이미 방문한 경우, 물에 잠긴 경우 continue
        if(ny < 0 || nx < 0 || ny >= n || nx >= m )continue;
        if(visited[ny][nx] || a[ny][nx] == 'T') continue;
        visited[ny][nx] = visited[y][x] + 1;
        ret += go(ny, nx); // 이동한 좌표로 재귀 호출하고 반환값을 누적
        visited[ny][nx] = 0; // 방문 여부 체크 배열 초기화
    }
    return ret;
}

int main(){
    cin >> n >> m >> k;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j]; // 입력받은 문자열을 2차원 배열에 저장
        }
    }
    visited[n - 1][0] = 1; // 시작 지점을 방문 여부 체크 배열에 표시
    cout << go(n - 1, 0) << "\n"; // 시작 지점에서부터 DFS 호출
}
