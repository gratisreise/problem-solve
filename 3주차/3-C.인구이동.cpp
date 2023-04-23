#include <bits/stdc++.h>
using namespace std;
int n, l, r, sum, cnt; 
int visited[54][54], a[54][54];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1}; 
vector<pair<int,int>> v; //나중에 계산할 좌표들 저장하는 vector

//DFS를 이용해 연합을 찾고 각 칸 수의 합을 해준다.
void dfs(int y, int x, vector<pair<int,int>> &v){ 
    visited[y][x] = 1;
    v.push_back({y,x});
    for(int i = 0; i < 4; i++){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n || visited[ny][nx]) continue;
        if(abs(a[ny][nx]- a[y][x]) >= l && abs(a[ny][nx] - a[y][x]) <= r){
            sum += a[ny][nx]; // 나중에 나눌려고
            dfs(ny, nx, v);
        }
    }
}

int main(){ 
    cin >> n >> l >> r;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    while(true){
        bool flag =0;
        fill(&visited[0][0], &visited[0][0] + 54 * 54, 0); //다시 방문되야할 필요성이 있으니깐
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < n; j++){ 
                    if(!visited[i][j]){ // 아직 방문하지 않은경우
                    v.clear();
                    sum = a[i][j]; // 여기서 더하기 초기화
                    dfs(i,j,v); // 

                    if(v.size() == 1) continue; // 연합 크기가 1인 경우는 계산할 필요 없음

                    for(pair<int,int> b : v){ // 연합 내 모든 좌표에 대해
                        a[b.first][b.second] = sum / v.size(); // 인구 이동
                        flag = 1; // 인구 이동이 일어났다는 표시
                    }
                }
            }
        }
        if(!flag) break; // 더 이상 인구 이동이 일어나지 않은 경우 break
        cnt++; // 인구이동 일어난 날짜 카운트
     } 
    cout<< cnt << "\n";
    return 0;
}

/*
인구 합 -> 안에 sum을 넣고 +
인구 분배 -> 벡터에 좌표저장 -> 순회 하면서 뿌려주기
날짜처리 -> 순회에서 인구이동 안에 -> bool flag를 처리

*/