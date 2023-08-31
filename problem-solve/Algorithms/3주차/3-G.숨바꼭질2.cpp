#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, k, visited[200004];
ll cnt[200004];
int main(){
    cin >> n >> k;
    if(n == k){
        puts("0"); puts("1");
        return 0;
    }
    queue<int> q;
    visited[n] = 1, cnt[n] = 1;
    q.push(n);
    while(q.size()){
        int now = q.front(); q.pop();
        for(int next : {now - 1, now + 1, now * 2}){
            if(next < 0 || next > 200000) continue;
            if(!visited[next]){
                visited[next] = visited[now] + 1;
                cnt[next] += cnt[now];
                q.push(next);
            }else if(visited[next] == visited[now] + 1){
                cnt[next] += cnt[now];
            }
        }
    }
    cout << visited[k] - 1 << '\n';
    cout << cnt[k] << '\n';
}
/*
강의들어야 겠다.
경우의 수를 구하는 cnt가 왜 +=로 되어있지??
내가 궁금한 것 어떤 아이디어? else if의 두의 조건 
수빈이링 동생 사이의 가중치가 같네, 최소의 시간과 경우의 수네 -> bfs
직선 상이니깐 배열이용, 반례는 있거나 없거나 최대 최소
경우의 수는 각 노드에서 정해진 숫자의 더하기 why?? 뻗어나가는 경우마다 하나의 가지이기 때문에
*/