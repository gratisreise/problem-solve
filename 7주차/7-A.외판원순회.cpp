#include<bits/stdc++.h>
#define MX 16
const int INF = 1e9;
using namespace std;
// dp[방문][결과값], 가중치 행열 저장
int n, dp[MX][1 << MX], dist[MX][MX];
// 재귀형 dp
int tsp(int here, int visited){
    if(visited == (1 << n) - 1){ // 모든 지점 방문
        // 들어오는 지점 없으면 INF 반환
        // 해당 그래프에서 경로 자체를 최적해 후보에서 제외
        return dist[here][0] ? dist[here][0] : INF; 
    }
    int &ret = dp[here][visited]; // dp에 값을 채워주는 과정이네
    if(ret != -1) return ret; // dp 자체를 -1로 했으니깐 -> 여기가 이해가 안되네
    ret = INF; // 최소값 비교를 위해 설정
    for(int i = 0; i < n; i++){ // 
        if(visited & (1 << i)) continue; // 방문했다면 컨티뉴
        if(dist[here][i] == 0) continue; // 경로가 없으면 컨티뉴
        //합연산의 이유는 각 지점의 방문을 표현
        ret = min(ret, dist[here][i] + tsp(i, visited | (1 << i)));
    }
    return ret; // 첫 번째 return과 두 번째 return의 차이??
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> dist[i][j];
        }
    }
    // 초기화 -> 왜 -1 -> 답이 될 수 없는 범위에서 초기화
    memset(dp, -1, sizeof(dp));
    // 입력을 0부터 받았으니 0부터 시작
    cout << tsp(0, 1) << '\n';
    return 0;
}
/*
goal: N과 비용행렬이 주어졌을 때, 가장 적은 비용을 들이는 순회 여행 경로

1. 어떻게 각 상황의 결과값을 저장하지??
2. 행렬이고 가중치가 다른 상황에서 어떻게 입력을 받지??
3. dp로 어떻게 표현하지??
*/