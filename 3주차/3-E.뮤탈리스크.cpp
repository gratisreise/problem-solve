#include <bits/stdc++.h>
using namespace std;
int a[3], n, visited[64][64][64];
int _a[6][3] = { // 방향벡터의 역할을 해줌 경우를 나눠주는 기준
    {9, 3, 1}, 
    {9, 1, 3},
    {3, 1, 9}, 
    {3, 9, 1},
    {1, 3, 9}, 
    {1, 9, 3}
};
struct A{ // 3개의 변수를 담아줄 그릇을 만들어 준다.
    int a, b, c;
};
queue<A> q;
int solve(int a, int b, int c){
    visited[a][b][c] = 1;
    q.push({a, b, c});
    while(q.size()){
        tie(a, b, c) = q.front();
        q.pop();
        if(visited[0][0][0]) break;// 시작부터 반복문 시작 필요성 없음
        for(int i = 0; i < 6; i++){ // 각 경우에 따라 반복
            // 음수 방지
            int na = max(0, a - _a[i][0]);
            int nb = max(0, b - _a[i][1]);
            int nc = max(0, c - _a[i][2]);
            if(visited[na][nb][nc]) continue; 
            visited[na][nb][nc] = visited[a][b][c] + 1;
            q.push({na, nb, nc});
        }
    }
    return visited[0][0][0] - 1; // 자가 자신을 방문처리 한거는 제외해야하기 때문에 -1
}
int main(){
    ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
    cin >> n; // 입력
    for(int i = 0; i < n; i++) cin >> a[i]; // 입력
    cout << solve(a[0], a[1], a[2]) << '\n'; // 함수호출해서 씀
    return 0;
}
/*
3명 동시공격 , 6가지 경우의 수 -> 6가지 방향의 bfs??

int 형 함수로 bfs표현 함

*/