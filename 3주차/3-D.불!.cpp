#include <bits/stdc++.h> 
using namespace std;
const int INF = 987654321;
const int mx = 1004;
char a[mx][mx]; int f_chk[mx][mx], ps_chk[mx][mx];
int n, m, sx, sy, y, x, ret;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};
bool in(int a, int b){
    return 0 <= a && a < n && 0 <= b && b < m;
}

int main(){
	ios::sync_with_stdio(0); cin.tie(0);cout.tie(0);    
    cin >> n >> m;
    queue<pair<int, int>> q; // 반복문 안에 큐푸쉬가 있기 때문에 그전에 선언
    fill(&f_chk[0][0], &f_chk[0][0] + mx * mx, INF); // inf 로 초기화 해주면서 
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] == 'F'){ //불이 있으면 최단거리 배열에 1넣어주고 큐에 푸쉬
                f_chk[i][j] = 1; q.push({i, j}); // 불은여러개
            }else if(a[i][j] == 'J'){ // 사람은 한명 저장
                sy = i; sx = j;
            }
        }
    }

    while(q.size()){//푸쉬된 불의 사이즈 만큼 이용
        tie(y, x) = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!in(ny, nx)) continue;
            if(f_chk[ny][nx] != INF || a[ny][nx] == '#') continue; // !이해
            f_chk[ny][nx] = f_chk[y][x] + 1; // 최단거리 배열 생성
            q.push({ny, nx});
        }
    }
    ps_chk[sy][sx] = 1; //들어가기 전에 1로 색칠
    q.push({sy, sx});
    while(q.size()){ //j의 최단거리를 이용하여 불과 비교해서 최단거리 배열을 이용함!!!
        tie(y, x) = q.front(); q.pop();
        if(x == m - 1 || y == n - 1 || x == 0 || y == 0){ //가장자리 도달하면 멈춤
            ret = ps_chk[y][x]; //도달하는 순간 브레이크를 걸어서 최소비교 안해도 됨 -> bfs의 묘미
            break;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!in(ny, nx)) continue; // 오버플로 방지
            if(ps_chk[ny][nx] || a[ny][nx] == '#') continue; //
            if(f_chk[ny][nx] <= ps_chk[y][x] + 1) continue; // 불의 최단거리와 j의 최단거리를 비교함 
            ps_chk[ny][nx] = ps_chk[y][x] + 1;
            q.push({ny, nx});
        }
    }
    if(ret != 0) cout << ret << '\n';
    else cout << "IMPOSSIBLE\n";
	return 0;
}

/*
불이 먼저 도달하는지 사람이 먼저 도달하는걸 어떻게 구현하지??
bfs
*/