#include<bits/stdc++.h>
using namespace std;
const int mx = 200000;
int n, k, visited[mx + 4], cnt[mx + 4];
int main(){
    cin >> n >> k;
    queue<int> q;
    visited[n] = 1;
    q.push(n);
    cnt[n] = 1;
    while(q.size()){
        int now = q.front(); q.pop();
        for(int next : {now - 1, now + 1, now * 2}){
            if(next < 0 || next > mx) continue;
            if(visited[next] == 0){
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