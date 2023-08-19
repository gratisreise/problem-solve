#include<bits/stdc++.h>
using namespace std;
const int mx = 500000;
int visited[2][mx + 4], n, k, ok, turn = 1;
int main(){
    cin >> n >> k;
    if(n == k){cout << 0 << '\n'; return 0;}
    queue<int> q;
    visited[0][n] = 1; // 왜2차원 배열을 선언했을까?
    q.push(n);
    while(q.size()){
        k += turn;
        if(k > mx) break;
        if(visited[turn % 2][k]){ // 시간 종료조건
            ok = true;
            break;
        }
        int qSize = q.size(); // 시간과 탐색의 횟수를 맞춰줄려고
        for(int i = 0; i < qSize; i++){
            int now = q.front(); q.pop();
            for(int next : {now + 1, now - 1, now * 2}){
                if(next < 0 || next > mx) continue;
                if(visited[turn % 2][next]) continue;
                visited[turn % 2][next] = visited[(turn + 1) % 2][next] + 1;
                if(next == k){ // bfs탐색 종료조건
                    ok = 1;
                    break;
                }
                q.push(next);
            }
            if(ok) break; // 탐색종료
        }
        if(ok) break; // 탐색종료
        turn++;
    }
    if(ok) cout << turn << '\n'; // ok
    else cout << -1 << '\n';
    return 0;
}