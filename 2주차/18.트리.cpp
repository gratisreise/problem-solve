#include <bits/stdc++.h>
using namespace std;
int n, r, temp, root;
vector<int> adj[54];
int dfs(int here){
    int ret = 0; 
    int child = 0;
    for(int there : adj[here]){
        if(there == r) continue;
        ret += dfs(there);
        child++; // 자식 노드 세기
    }
    if(child == 0) return 1;
    return ret;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> temp;
        if(temp == -1) root = i;
        else adj[temp].push_back(i);
    }
    cin >> r;
    if(r == root){
        cout << 0 << '\n'; return 0;
    }
    cout << dfs(root) << '\n';
    return 0;
}
/* 
 계층을 나타내주기 위해 단방향으로 해주고 
    
*/