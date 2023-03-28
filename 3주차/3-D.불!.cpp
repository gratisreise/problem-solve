#include <bits/stdc++.h> 
using namespace std;
const int INF = 987654321;
char a[1004][1004];
int n, m, sx, sy, y, x, ret;
int dx[] = {-1, 0, 1, 0}, dy[] = {0, -1, 0, 1};
int fir_check[1004][1004], person_check[1004][1004];
bool in(int a, int b){
    return 0 <= a && a < n && 0 <= b && b < m;
}
int main(){
    ios_base::sync_with_stdio(false);cin.tie(0); cout.tie(0); 
    queue<pair<int, int>> q; //bfs순환하는데 사용할려고
    cin >> n >> m; 
    fill(&fire_check[0][0], &fire_check[0][0] + 1004 * 1004, INF); // inf 로 초기화 해주면서 
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] == 'F'){ //불이 있으면 최단거리 배열에 1넣어주고 큐에 푸쉬
                fire_check[i][j] = 1; q.push({i, j}); // 불은여러개
            }else if(a[i][j] == 'J'){ // 사람은 한명 저장
                sy = i; sx = j;
            }
        }
    }

    while(q.size()){//푸쉬된 불의 사이즈 만큼 이용
        tie(y, x) = q.front(); 
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!in(ny, nx)) continue;
            if(fire_check[ny][nx] != INF || a[ny][nx] == '#') continue; // !이해
            fire_check[ny][nx] = fire_check[y][x] + 1; // 최단거리 배열 생성
            q.push({ny, nx});
        }
    }
    person_check[sy][sx] = 1; //들어가기 전에 1로 색칠
    q.push({sy, sx});
    while(q.size()){
        int y =  q.front().first; //
        int x =  q.front().second;
        q.pop();
        if(x == m - 1 || y == n - 1 || x == 0 || y == 0){ //가장자리 도달하면 멈춤
            ret = person_check[y][x]; //도달하는 순간 브레이크를 걸어서 최소비교 안해도 됨
            break;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(!in(ny, nx)) continue; // 오버플로 방지
            if(person_check[ny][nx] || a[ny][nx] == '#') continue; //
            if(fire_check[ny][nx] <= person_check[y][x] + 1) continue; // 불에지져지면 잣됨
            person_check[ny][nx] = person_check[y][x] + 1;
            q.push({ny, nx});
        }
    }
    if(ret != 0) cout << ret << '\n';
    else cout << "IMPOSSIBLE \n";
	return 0;
}
/*
3 3
...
.J.
... 
*/
