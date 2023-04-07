#include<bits/stdc++.h>
using namespace std;
int n, m, y, x, ret;
int a[10][10], visited[10][10];
int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};
vector<pair<int, int>> wallList, virusList;
void dfs(int y, int x){ //바이러스 퍼져나가기
    visited[y][x] = 1;
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(a[ny][nx] == 1 || visited[ny][nx]) continue;
        dfs(ny, nx);
    }
}
int solve(){ //정수형 함수를 쓰고 
    //바이러스 퍼뜨리기
    fill(&visited[0][0], &visited[0][0] + 10 * 10, 0);
    for(auto b : virusList){
        visited[b.first][b.second] = 1;
        dfs(b.first, b.second);
    }
    //안전영역 카운팅
    int cnt = 0; // 조합뽑는 반복에 들어가기 때문에
    for(int i = 0; i < n; i++){ //
        for(int j = 0; j < m; j++){
            if(a[i][j] == 0 && !visited[i][j]) cnt++;
        }
    }
    return cnt;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> a[i][j];
            if(a[i][j] == 0) wallList.push_back({i, j});
            if(a[i][j] == 2) virusList.push_back({i, j});
        }
    }

    for(int i = 0; i < wallList.size(); i++){ //벽세우기
        for(int j = 0; j < i; j++){
            for(int k = 0; k < j; k++){
                a[wallList[i].first][wallList[i].second] = 1;
                a[wallList[j].first][wallList[j].second] = 1;
                a[wallList[k].first][wallList[k].second] = 1;
                ret = max(ret, solve()); //안전영역최대값
                //반복하여 뽑아서 다시 1로 채워줘야하기 때문에 0으로 초기화
                a[wallList[i].first][wallList[i].second] = 0;
                a[wallList[j].first][wallList[j].second] = 0;
                a[wallList[k].first][wallList[k].second] = 0;
            }
        }
    }
    cout << ret << '\n';
}