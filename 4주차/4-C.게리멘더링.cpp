#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;  
//  ret : 최종답
int n, m, temp, ret = INF; 
// a[i] : i번 정점의 인구수, comp: i번 정점이 속한 선거구 번호, 
int a[11], comp[11], visited[11];
vector<int> adj[11]; // 연결리스트 벡터로 표현
pair<int, int> dfs(int here, int value){
    visited[here] = 1; // 색칠 
    pair<int, int> ret = {1, a[here]}; // {노드수체크, 인구수}
    for(int there : adj[here]){ 
        if(comp[there] != value) continue; //같은 색 아니면 패스
        if(visited[there]) continue; // 이미 방문한 곳 패스
        pair<int, int> _temp = dfs(there, value); 
        ret.first += _temp.first;   // 연결된 노드 수 
        ret.second += _temp.second; // 인구수 합산
    }
    return ret; 
}  
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 1; i <= n; i++) cin >> a[i];  // 정점의 인구수 저장
    for(int i = 1; i <= n; i++){ // 트리 입력 방법
        cin >> m; 
        for(int j = 0; j < m; j++){ // 양방향으로
            cin >> temp; 
            adj[temp].push_back(i);
            adj[i].push_back(temp); 
        }
    }
    for(int i = 1; i < (1 << n) - 1; i++){ // 1번부터니깐??
        fill(comp, comp + 11, 0);
        fill(visited, visited + 11, 0);
        //각 선거구에 구성된 정점의 번호를 저장하는 변수
        // int idx1 = -1, idx2 = -1; 
        for(int j = 0; j < n; j++){ // 1,으로 선거구 유형 저장
            if(i & (1 << j)) comp[j + 1] = 1, idx1 = j + 1;
            else idx2 = j + 1;
        }
        // 정점의 개수와 인구수의 합을 저장하는 pair, dfs 두번들어가서 컴포넌트수 세기
        pair<int, int> comp1 = dfs(idx1, 1);
        pair<int, int> comp2 = dfs(idx2, 0);
        // 각 노드의 숫자가 같아야 함
        if(comp1.first + comp2.first == n) ret = min(ret, abs(comp1.second - comp2.second));
    }
    cout << (ret == INF ? -1 : ret) << "\n";
}
/*
1. 입력 받기
    - 정점의 개수 n과 인구수a[i]를 입력 받는다.
    - 각 정점과 인접한 정점들의 정보를 인접 리스트에 저장
2. 비트마스크를 이용하여 조합 만들기
    - 1부터 n까지 번호가 매겨진 각 정점들을 비트마스크를 이용하여 2개의 조합으로 나눕니다.
    - 비트마스크를 이용하여 1로 표시된 정점들의 집합과 0으로 표시된 정점들의 집합을 만듭니다.
3. DFS를 이용하여 두 그룹의 인구수 계산
    -두 그룹 각각에서 DFS를 실행하면서, 그룹의 크기와 인구수의 합을 구합니다.
4. 결과 계산
    -두 그룹의 크기가 전체 정점의 개수와 같으면, 즉 
    두 그룹이 모두 연결되어 있다면 두 그룹의 인구수 차이를 구하여 최소값을 업데이트합니다.

*/