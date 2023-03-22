#include <bits/stdc++.h>
using namespace std;
int m, n, k, y, x, ret, ny, nx, t;
int a[51][51]; bool visited[51][51];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        ny = y + dy[i];
        nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] == 1 && !visited[ny][nx]){
            dfs(ny, nx);
        }
    }
    return;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> t;
    while(t--){
        fill(&a[0][0], &a[0][0] + 51 * 51, 0);
        fill(&visited[0][0], &visited[0][0] + 51 * 51, 0);
        ret = 0;
        cin >> m >> n >> k;
        while(k--){
            cin >> x >> y;
            a[y][x] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1 && !visited[i][j]){
                    dfs(i,j); ret++;
                }
            }
        }
        cout << ret << '\n';
    }
    return 0;
}

지렁이 몇마리 필요한가?
지렁이가요 배추가 인접한 곳은 타고 넘어가며 커버 가능 -> dfs
맵과 방향벡터 사용
테스트 케이스 -> 초기화 -> 입력 -> dfs
1. dfs가 쓰이느 기본적인 상황
2. 테스트 케이스로 인한 2차원 배열의 초기화 사용
3. y, x 의 입력되는 순서 기억!!
