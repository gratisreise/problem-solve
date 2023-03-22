#include <bits/stdc++.h>
using namespace std;
 
vector<int> v[10001];
int dp[10001], mx, visited[10001], n, m, a, b;
 
int dfs(int here) { // 해킹가능한 컴퓨터의 갯수 구하기
	visited[here] = 1;
	int ret = 1; 
	for(int there : v[here]){
		if(visited[there]) continue;
		ret += dfs(there); //재귀호출하면서 더해짐
	} 
	return ret;
}
 
int main() { 
	ios_base::sync_with_stdio(0); cin.tie(0); 
	cin >> n >> m;  
	while (m--) { //벡터에 집어
     	cin >> a >> b;  
	    v[b].push_back(a);
	} 
	for (int i = 1; i <= n; i++) {
		memset(visited, 0, sizeof(visited));
		dp[i] = dfs(i); 
		mx = max(dp[i], mx);
	} 
	for (int i = 1; i <= n; i++) if (mx == dp[i]) cout << i << " "; 
	return 0;
}