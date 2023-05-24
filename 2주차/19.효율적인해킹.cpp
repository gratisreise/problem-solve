#include<bits/stdc++.h>
using namespace std;
vector<int> v[10001];
int dp[10001], mx, visited[10001], n, m, a, b;
//
int dfs(int here){
    visited[here] = 1;
    int ret = 1;
    for(int there : v[here]){
        if(visited[there]) continue;
        ret += dfs(there);
    }
    return ret;
}
//
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    while(m--){
        cin >> a >> b;
        v[b].push_back(a);
    }
    //
    for(int i = 1; i <= n; i++){
        memset(visited, 0, sizeof(visited));
        dp[i] = dfs(i);
        mx = max(dp[i], mx);
    }
    //
    for(int i = 1; i <= n; i++) if(mx == dp[i]) coout << i << " ";
    return 0;
}


#include<bits/stdc++.h>
using namespace std;
int cnt, ret, a, b, n , m;
vector<int> v[10004];
map<int, vector<int>> mp;
void dfs(int here){
    for(int there : v[here]){ 
        dfs(there); 
        cnt++;
    }
    return;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    while(m--){
        cin >> a >> b;
        v[b].push_back(a);
    }
    for(int i = 1; i <= n; i++){
        cnt = 0; dfs(i);
        mp[cnt].push_back(i);
        ret = max(ret, cnt);
    }
    for(int i : mp[ret]) cout << i << ' ';
}

/*
단방향 간선을 가지는 트리구조를 이용하여
dfs로 탐색을 해주면 된다.
*/)