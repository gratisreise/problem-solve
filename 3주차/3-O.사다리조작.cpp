// 필요한 헤더 파일 포함
#include <bits/stdc++.h>
using namespace std;

// 최대값 선언 종류
const int INF = 987654321;
const int INF2 = 1e9;
const long long INF3 = 1e18;
// 전역 변수
// a, b: 이미 놓여진 가로선의 위치
// ret: 최소 가로선 개수
// visited: visited[i][j] = i번째 가로선의 j번째 세로줄에 가로선이 있는지 여부를 저장하는 2차원 배열
int n, m, h, a, b, ret = INF, visited[34][34];

// 현재 상태가 올바른 사다리인지 체크하는 함수
bool check(){ //visited가 받는게 11부터 받는다고 생각했으니깐
    for(int i = 1; i <= n; i++){ // 모든 세로선에 대해서
        int start = i; // 자기자신 오는지 확인
        for(int j = 1; j <= h; j++){ // 모든 가로선에 대해서
            if(visited[j][start]) start++; // 오른쪽으로 이동
            else if(visited[j][start - 1]) start--; // 왼쪽으로 이동
        }
        if(start != i) return false; // 시작점과 도착점이 다르면 false 반환
    }
    return true; // 모든 시작점과 도착점이 일치하면 true 반환
}

// dfs 함수 -> 3보다 큰지 체크하면서 최소값 찾기, 사다리 다리 놓아보면서 체크
void go(int here, int cnt){ // cnt는 추가되는 가로선 갯수
    if(cnt > 3 || cnt >= ret) return; // cnt가 3보다 크거나 현재 최소값보다 크면 리턴
    if(check()){ // i출발해서 i로 도착햇으면
        ret = min(ret, cnt); // 최소값 갱신
        return;
    }
    for(int i = here; i <= h; i++){ // 가로선 추가
        for(int j = 1; j <= n; j++){ //입력받는 숫자가 1부터 시작하니깐
            // 이전, 이후 사다리 연속하난 체크
            if(visited[i][j] || visited[i][j - 1] || visited[i][j + 1]) continue; // 이미 가로선이 있거나 양쪽에 가로선이 있으면 스킵
            visited[i][j] = 1; // 가로선 추가
            go(i, cnt + 1); // 완탐
            visited[i][j] = 0; // 가로선 제거
        }
    }
}

// main 함수
int main() {
    // 입출력 속도 향상
	ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    // 입력
    cin >> n >> m >> h;
    for(int i = 0; i < m; i++){
        cin >> a >> b;
        // visited[a][b] = 1; // 가로선 추가
    }
    
    // dfs 탐색
    go(1, 0);
    
    // 출력
    cout << ((ret == INF) ? -1 : ret) << "\n"; // 최소값이 갱신되지 않았으면 -1 출력, 아니면 최소값 출력
	return 0;
}
/*
사다리 추가해서 자기자신 오게 만들게하는 경우 몇가지 인지 구하라
사다리 추가가능 갯수 추가 -> 가능한지 확인 -> 최소갱신
 - > 3초과, 불가능 -1 -> ret 갱신안됬으면 -1, 갱신됬으면 그 값 출력

dfs, 완탐, 백트래킹
*/
