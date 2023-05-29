#include<bits/stdc++.h>
using namespace std; 
int n, m, y, x, ret; 
int visited[54][54]; char a[54][54];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};
// vector<pair<int, int>> Land;
void bfs(int y, int x){
    memset(visited, 0, sizeof(visited)); 
    visited[y][x] = 1; 
    queue<pair<int, int>> q; 
    q.push({y, x}); 
    while(q.size()){
        tie(y, x) = q.front(); q.pop(); 
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i]; 
            int nx = x + dx[i]; 
            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue; 
            if(visited[ny][nx] || a[ny][nx] == 'W') continue; 
            visited[ny][nx] = visited[y][x] + 1; 
            q.push({ny, nx});
            ret = max(ret, visited[ny][nx]); // 탐색하면서 최대찾기
        }
    }
    return;
}
int main(){
    cin >> n >> m; 
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j]; 
        }
    }
    for(pair<int, int> L : Land) bfs(L.first, L.second);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(a[i][j] == 'L') bfs(i, j); 
        }
    } 
    cout << ret - 1 << "\n"; //거리를 구하는거니깐 -1 해주면 됨
}

bfs 탐색을 변형시켜서 최대값 찾기
시간을 구하는 거니깐 -1을 해줘야 함
육지의 각 좌표마다 방문배열을 만들면서 대소비교 하는 것이기 때문에 초기화 필요!!