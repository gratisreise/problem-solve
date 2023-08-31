#include <bits/stdc++.h>
using namespace std;
const int mx = 1504;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1}; 
int n, m, day, swanY, swanX, y, x;
int v_swan[mx][mx], visited[mx][mx]; char a[mx][mx];
queue<pair<int, int>> wQ, sQ, w_tempQ, s_tempQ;
// q를 초기화 하는 함수
void Qclear(queue<pair<int, int>> &q){ //q의 값 초기화, 더 빠름
   queue<pair<int, int>> empty; // 빠름
   swap(q, empty);
    //while(q.size()) q.pop();   더 느림
}  
//물이 녹는 함수
void water_melting(){
    while(wQ.size()){
		tie(y, x) = wQ.front();  
        wQ.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx])continue;
            if(a[ny][nx] == 'X'){ // 얼음 녹이기
                visited[ny][nx] = 1; 
                w_tempQ.push({ny, nx}); // 내일을 위한 대비
                a[ny][nx] = '.'; 
            } 
        }
    }
}
// 백조의 움직임
bool move_swan(){
    while(sQ.size()){
		tie(y, x) = sQ.front(); 
        sQ.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m || v_swan[ny][nx])continue;
            v_swan[ny][nx] = 1;
            // 핵심 -> 
            if(a[ny][nx] == '.') sQ.push({ny, nx}); // 물이면 푸쉬해서 이동
            else if(a[ny][nx] == 'X') s_tempQ.push({ny, nx}); // 물X 다음 시작 지점 저장
            else if(a[ny][nx] == 'L') return true; //백조가 만남 
        }
    }
	return false;// 못 만남 
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie();cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] == 'L'){swanY = i; swanX = j;}
            // 물을 녹이기 위한 지점 bfs
            if(a[i][j] == '.' || a[i][j] == 'L')visited[i][j] = 1, 
            wQ.push({i, j}); 
        }
    } 
    sQ.push({swanY, swanX}); 
    v_swan[swanY][swanX] = 1; 
    while(1){ 
        if(move_swan()) break;
        water_melting();
        wQ = w_tempQ;
        sQ = s_tempQ;
        Qclear(w_tempQ); // 초기화
        Qclear(s_tempQ); // 초기화
        day++;
    }
    cout << day << "\n";
    return 0;
}
