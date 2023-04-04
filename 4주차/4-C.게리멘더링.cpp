#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;  
int n, m, temp, ret = INF;
int a[11], comp[11], visited[11];
vector<int> adj[11]; 
pair<int, int> dfs(int here, int value){
    visited[here] = 1; // 방문한 노드를 표시한다.
    pair<int, int> ret = {1, a[here]}; // ret 변수의 첫 번째 요소는 연결된 노드의 개수를 나타내고, 두 번째 요소는 연결된 노드의 값의 합을 나타낸다.
    for(int there : adj[here]){ //here 노드와 연결된 모든 노드에 대해 반복한다.
        if(comp[there] != value) continue; // 현재 확인하는 노드가 인접한 노드 중에 value 값과 다른 그룹에 속한 노드라면, 넘어간다.
        if(visited[there]) continue;// 이미 방문한 노드라면, 넘어간다.
        pair<int, int> _temp = dfs(there, value); // 인접한 노드를 재귀적으로 탐색한다.
        ret.first += _temp.first;  // ret 변수의 첫 번째 요소를 갱신한다.
        ret.second += _temp.second;  // ret 변수 의 두 번째 요소를 갱신한다.
    }
    return ret; //연결된 노드의 개수와 값의 합을 반환한다.
}  
int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);

    cin >> n;

    for(int i = 1; i <= n; i++) cin >> a[i]; //노드의 값들을 입력받는다.

    for(int i = 1; i <= n; i++){
        cin >> m; 
        for(int j = 0; j < m; j++){
            cin >> temp; 
            // 별다른 말 없으면 양방향 간선
            adj[i].push_back(temp); 
            adj[temp].push_back(i); 
        } 
    }
    // 비트마스크를 이용하여 모든 경우의 수에 대해 반복
    for(int i = 1; i < (1 << n) - 1; i++){
        fill(comp, comp + 11, 0); // comp 배열을 0으로 초기화한다.
        fill(visited, visited + 11, 0); // visited 배열을 0으로 초기화한다.
        int idx1 = -1, idx2 = -1; 
        for(int j = 0; j < n; j++){
            if(i & (1 << j)){comp[j + 1] = 1; idx1 = j + 1;} // 비트마스크를 이용하여 노드를 2개의 그룹으로
            else idx2 = j + 1; 
        }
        pair<int, int> comp1 = dfs(idx1, 1);
        pair<int, int> comp2 = dfs(idx2, 0);   
        if(comp1.first + comp2.first == n) ret = min(ret, abs(comp1.second - comp2.second)); 
    }
    cout << (ret == INF ? -1 : ret)<< "\n";
}