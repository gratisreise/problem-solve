#include<bits/stdc++.h>
using namespace std;
int n, m, a, b, c[10004], visited[10004], mx = 0;
vector<int> v[10004];
int dfs(int here){
    visited[here] = 1;
    int ret = 1;
    for(int there : v[here]){
        if(visited[there]) continue;
        ret += dfs(there);
    }
    return ret;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i < m; i++){
        cin >> a >> b;
        v[b].push_back(a);
    }
    for(int i = 1; i <= n; i++){
        memset(visited, 0, sizeof(visited));
        c[i] = dfs(i);
        mx = max(c[i], mx);
    }
    for(int i = 1; i <= n; i++) if(c[i] == mx) cout << i << ' ';
}