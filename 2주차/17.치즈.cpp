#include <bits/stdc++.h>
using namespace std; 
int n,m,cnt,cnt2;
int a[104][104], visited[104][104];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};    
vector <pair<int, int>> v; //녹아야할 치즈를 담는다
void go(int y, int x){
	visited[y][x] = 1;
    if(a[y][x] == 1){ //치즈양반 딱 걸렸수다!!
        v.push_back({y, x});
        return;
    }
    for(int i=0; i<4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx])continue; 
        go(ny, nx);
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
    while(true){
        cnt2 = 0;
        fill(&visited[0][0], &visited[0][0] + 104 * 104,0);
        v.clear(); 
        go(0, 0); 
        for(pair<int, int> b : v){
			cnt2++; // 녹아지는 순간을 체크
			a[b.first][b.second] = 0;
		}   
        bool flag = 0; // 치즈 있으면 1 없으면 0
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != 0) flag = 1;
            }
        }
        cnt++;
        if(!flag) break;
    }
    cout << cnt << "\n" << cnt2 << '\n'; 
}

#include<bits/stdc++.h>
using namespace std;
#define prev noah
int n, m, ret, a[104][104], visited[104][104], prev;
const int dy[] = {-1, 0, 1, 0};
const int dx[] = {0, 1, 0, -1};
void dfs(int y, int x){
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
        if(a[ny][nx]){visited[ny][nx] = 1; a[ny][nx] = 0; continue;}
        dfs(ny, nx);
    }
}
int main(){
    cin >> n >> m;
    int cnt = 0;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
        }
    }
    while(1){
        memset(visited, 0, sizeof(visited));
        dfs(0, 0);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j]) cnt++;
            }
        }
        ret++;
        if(cnt == 0) break; 
        prev = cnt;
    } 
    cout << ret << '\n' << prev << '\n';
}

/*
1. dfs를 들어갈 때 a[i][j]가 1이면 칠하고 0으로 바꾸고
*/