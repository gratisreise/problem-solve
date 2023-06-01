#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int mx = 200000; //제한 범위 20만 
int n, k, visited[mx + 4]; 
ll cnt[mx + 4];
int main(){
    cin >> n >> k;
    if(n == k){ // 반례 찾기 : 
        puts("0"); puts("1");
        return 0;
    }
    queue<int> q;
    visited[n] = 1; cnt[n] = 1;
    q.push(n);
    while(q.size()){
        int now = q.front(); q.pop();
        for(int next : {now + 1, now - 1, now * 2}){ //배열 요소중 하나 골라서 연산
            if(next < 0 || next > mx) continue;
            if(!visited[next]){ // 최단시간이므로 방문배열 -> 최소시간배열
                q.push(next);
                visited[next] = visited[now] + 1; // 최소시간
                cnt[next] += cnt[now]; // 경우의 수
            }else if(visited[next] == visited[now] + 1){ //최단 시간인 다른 경우의 수
                cnt[next] += cnt[now];
            }
        }
    }
    cout << visited[k] - 1 << '\n'; // 자기자신 제외 -1
    cout << cnt[k] << '\n'; // 경우의 수
}
/*
강의들어야 겠다.
내가 궁금한 것 어떤 아이디어? else if 두의 조건
수빈이링 동생 사이의 가중치가 같네, 최소의 시간과 경우의 수네 -> bfs
직선 상이니깐 배열이용, 반례는 있거나 없거나 최대 최소
경우의 수는 각 노드에서 정해진 숫자의 더하기 why?? 뻗어나가는 경우마다 하나의 가지이기 때문에
*/