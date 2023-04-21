#include <bits/stdc++.h>
using namespace std;
const int max_n = 1501;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1}; 
int R, C, day, swanY, swanX, y, x;
int v_swan[max_n][max_n], visited[max_n][max_n]; char a[max_n][max_n];
queue<pair<int, int>> wQ, w_tempQ, sQ, s_tempQ;
string s;
void Qclear(queue<pair<int, int>> &q){
   queue<pair<int, int>> empty;
   swap(q,empty);
}  
void water_melting(){
    while(wQ.size()){
		tie(y, x) = wQ.front();  
        wQ.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx < 0 || nx >= C || visited[ny][nx])continue;
            if(a[ny][nx] == 'X'){
                visited[ny][nx] = 1; 
                w_tempQ.push({ny, nx});
                a[ny][nx] = '.'; 
            } 
        }
    }
}
bool move_swan(){
    while(sQ.size()){
		tie(y, x) = sQ.front(); 
        sQ.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= R || nx < 0 || nx >= C || v_swan[ny][nx])continue;
            v_swan[ny][nx] = 1;
            if(a[ny][nx] == '.')sQ.push({ny, nx});
            else if(a[ny][nx] == 'X') s_tempQ.push({ny, nx});
            else if(a[ny][nx] == 'L') return true;
        }
    }
	return false;
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie();cout.tie(0);
    cin >> R >> C;
    for(int i = 0; i < R; i++){
        cin >> s;
        for(int j = 0; j < C; j++){
            a[i][j] = s[j];
            if(a[i][j] == 'L'){swanY = i; swanX = j;}
            if(a[i][j] == '.' || a[i][j] == 'L')visited[i][j] = 1, 
            wQ.push({i, j});
        }
    } 
    sQ.push({swanY, swanX}); 
    v_swan[swanY][swanX] = 1; 
    while(true){  
        if(move_swan()) break;
        water_melting();
        wQ = w_tempQ;
        sQ = s_tempQ;
        Qclear(w_tempQ);
        Qclear(s_tempQ);
        day++;
    }
    cout << day << "\n";
    return 0;
}
