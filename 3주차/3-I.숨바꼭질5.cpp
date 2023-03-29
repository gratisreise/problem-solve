#include<bits/stdc++.h>
using namespace std;
const int mx = 500004;
int visited[2][mx]; // 앞의 배열 수빈이는 홀짝만 구분해도 되니깐 2만 넣어서 복잡도 다운
int a, b, ok, turn = 1;  // turn은 연속되는 수의 합을 만들어줘야하기 때문에 = 1;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> a >> b;
    if(a == b) {cout << 0 << '\n'; return 0;}
    queue<int> q;
    visited[0][a] = 1;
    q.push(a);
    while(q.size()){
        b +=  turn; //1+2+3+4+....
        if(b > mx) break; // b는 계속 더해주니깐 범위제한 걸어줌
        if(visited[turn % 2][b]){
            ok = true; //만났는지 안 만났는지 체크하는 불리언
            break;
        }
        int qSize = q.size(); // floodfill 입니다.
        for(int i = 0; i < qSize; i++){
            int x = q.front(); q.pop();
            for(int nx : {x + 1, x - 1, x * 2}){
                if(nx < 0 || nx > mx || visited[turn % 2][nx]) continue;
                visited[turn % 2][nx] = visited[(turn + 1) % 2][x + 1];
                if(nx == b){
                    ok = 1; break;
                }
                q.push(nx);
            }
            if(ok) break; //만났으면 브레이크
        }
        if(ok)break; // 만났으면 브레이크
        turn++; // 1+2+3+4 ......
    }
    if(ok) cout << turn << '\n';
    else cout << -1 << '\n';
    return 0;
}
/*
1. 50만 곱 50만 이니깐 공간복잡도 고려해야함 -> 수빈이가 홀짝인지 체크만 하면 되겠네!!
2. fluidflill 로직
*/