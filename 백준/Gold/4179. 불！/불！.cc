#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const int mx = 1004;
int n, m, sy, sx, y, x, ret;
char a[mx][mx]; int v_f[mx][mx], v_j[mx][mx];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    queue<pair<int, int>> q;
    fill(&v_f[0][0], &v_f[0][0] + mx * mx, INF);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] == 'F') v_f[i][j] = 1, q.push({i, j});
            if(a[i][j] == 'J') sy = i, sx = j;
        }
    }

    while(q.size()){
        tie(y, x) = q.front(); q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(v_f[ny][nx] != INF || a[ny][nx] == '#') continue;
            v_f[ny][nx] = v_f[y][x] + 1;
            q.push({ny, nx});
        }
    }

    v_j[sy][sx] = 1;
    q.push({sy, sx});
    while(q.size()){
        tie(y, x) = q.front(); q.pop();
        if(x == m - 1 || y == n - 1 || x == 0 || y == 0){
            ret = v_j[y][x]; break;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if(v_j[ny][nx] || a[ny][nx] == '#') continue;
            if(v_f[ny][nx] <= v_j[y][x] + 1) continue;
            v_j[ny][nx] = v_j[y][x] + 1;
            q.push({ny, nx});
        }
    }
    if(ret != 0) cout << ret << '\n';
    else cout << "IMPOSSIBLE\n";
    return 0;

}