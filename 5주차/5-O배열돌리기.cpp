#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
const int dy[] = {0, 1, 0, -1}; 
const int dx[] = {1, 0, -1, 0};
int n, m, k, r, c, s, dir, sy, sx, ey, ex, ret = INF; // ret: 회전 연산을 저장
int a[104][104], b[104][104], visited[104][104];
vector<pair<int, int>> vv; // 회전 연산을 적용하기 위해 방문한 좌표를 저장하는 벡터
vector<int> v_idx; // 회전 연산을 적용할 순서를 저장하는 벡터
struct A{
	int y, x, cnt; 
}; 
vector<A> v; // 회전 연산 정보를 저장하는 벡터
bool cmp(A &a, A &b){
	if(a.y == b.y) return a.x < b.x; 
	return a.y < b.y;
}  
void go(int y, int x, int first){   
	if(!first && y == sy && x == sx) dir++; 
	if(!first && y == sy && x == ex) dir++; 
	if(!first && y == ey && x == ex) dir++;
	if(!first && y == ey && x == sx) dir++; 
	int ny = y + dy[dir]; 
	int nx = x + dx[dir]; 
	if(visited[ny][nx]) return;
	visited[ny][nx] = 1; 
	vv.push_back({ny, nx});
	go(ny, nx, 0); 
}
void rotateAll(int y, int x, int cnt){
	for(int i = 1; i <= cnt; i++){
		sy = y - 1 * i; 
		sx = x - 1 * i; 
		ey = y + 1 * i; 
		ex = x + 1 * i; 
		vv.clear();
		dir = 0;
		memset(visited, 0, sizeof(visited));  
		visited[sy][sx] = 1; 
		vv.push_back({sy, sx});
		go(sy, sx, 1); 
		vector<int> vvv; 
		for(pair<int, int> c : vv)vvv.push_back(b[c.f][c.s]); 
		rotate(vvv.begin(), vvv.begin() + vvv.size() - 1, vvv.end());
		for(int i = 0; i < vv.size(); i++) b[vv[i].f][vv[i].s] = vvv[i]; 
	}  
}
int solve(){
	for(int i : v_idx) rotateAll(v[i].y, v[i].x, v[i].cnt);
	int _ret = INF;
	for(int i = 0; i < n; i++){
		int cnt = 0;
		for(int j = 0; j < m; j++) cnt += b[i][j];
		_ret = min(_ret, cnt);
	}
	return _ret; 
}
int main(){
	cin >> n >> m >> k; 
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cin >> a[i][j]; 
		}
	}
	for(int i = 0; i < k; i++){
		cin >> r >> c >> s; r--; c--;
		v.push_back({r, c, s}); 
		v_idx.push_back(i);
	} 
	do{
		memcpy(b, a, sizeof(b));
		ret = min(ret, solve());
	}while(next_permutation(v_idx.begin(), v_idx.end())); 
	cout << ret << "\n";
	return 0;
}
/*
위 코드의 주요 로직은 다음과 같습니다.

입력으로 주어진 배열 a를 b에 복사합니다.
v_idx의 모든 순열에 대해서 다음 과정을 반복합니다.
현재 순열에 대해, v에 저장된 순서대로 회전 연산을 b에 적용합니다.
b의 각 행의 합 중 최솟값을 계산하여 ret에 저장합니다.
모든 순열에 대해 반복한 후, ret을 출력합니다.
회전 연산을 적용하는 rotateAll 함수에서는 다음과 같은 과정을 수행합니다.

회전 연산을 적용할 영역의 시작점과 끝점을 계산합니다.
vv 벡터를 초기화하고, visited 배열을 초기화합니다.
시작점을 방문 처리하고, vv에 저장합니다.
go 함수를 호출하여 회전 연산이 적용될 좌표들을 모두 vv에 저장합니다.
vv에 저장된 좌표들에 대해 회전 연산을 적용하고, 결과를 b에 저장합니다.


*/