#include <bits/stdc++.h> 
using namespace std;
const int INF = 1e9;
const int mx = 1004;
char a[mx][mx]; int v_f[mx][mx], v_j[mx][mx];
int n, m, sx, sy, y, x, ret;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main(){
	ios::sync_with_stdio(0); cin.tie(0);cout.tie(0);    
    cin >> n >> m;
    queue<pair<int, int>> q; // 반복문 안에 큐푸쉬가 있기 때문에 그전에 선언
    // q
    fill(&v_f[0][0], &v_f[0][0] + mx * mx, INF); // 불이 없을 때의 반례를 해결 -> 가장 큰값으로 어디로가든 병훈이 갈 수 있게
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            //불이 있으면 최단거리 배열에 1넣어주고 큐에 푸쉬, 불이 여러개 가능함
            if(a[i][j] == 'F') v_f[i][j] = 1, q.push({i, j}); 
            // 사람은 한명
            if(a[i][j] == 'J') sy = i, sx = j;
        }
    }

    while(q.size()){//푸쉬된 불의 사이즈 만큼 이용 ,선입 선출이라 여러개여도 시작점 고려X
        tie(y, x) = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(v_f[ny][nx] != INF || a[ny][nx] == '#') continue;
            v_f[ny][nx] = v_f[y][x] + 1; // 최단거리 배열 생성
            q.push({ny, nx});
        }
    }
    v_j[sy][sx] = 1; //들어가기 전에 1로 색칠
    q.push({sy, sx});
    while(q.size()){ //j의 최단거리를 이용하여 불과 비교해서 최단거리 배열을 이용함!!!
        tie(y, x) = q.front(); q.pop();
        if(x == m - 1 || y == n - 1 || x == 0 || y == 0){ //가장자리 도달하면 멈춤
            ret = v_j[y][x]; //bfs는 최단거리라 어차피 min비교 안해도 된다.
            break;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

            if(v_j[ny][nx] || a[ny][nx] == '#') continue;
            // 불의 최단거리와 j의 최단거리를 비교하여 불이 더 빠르면 컨티뉴 
            if(v_f[ny][nx] <= v_j[y][x] + 1) continue; 
            v_j[ny][nx] = v_j[y][x] + 1;
            q.push({ny, nx});
        }
    }
    if(ret != 0) cout << ret << '\n';
    else cout << "IMPOSSIBLE\n";
	return 0;
}

/*
불이 먼저 도달하는지 사람이 먼저 도달하는걸 어떻게 구현하지?? -> 방문배열 2개 써서 비교하면됨
bfs
*/
불이 여러개 처리 -> 그냥 입력받을 때 푸쉬를 해주면 된다.
INF로 초기화시켜준 이유가 뭐냐? -> 사람 bfs탐색할 때 불의 방문배열이 커야 지나갈 수 있으니깐
