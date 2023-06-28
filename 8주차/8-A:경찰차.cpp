#include<bits/stdc++.h>
using namespace std;
// px = x의 합, py = y의 합, 거리합저장??, 
int n, w, px[1003], py[1003], dp[1003][1003], y, x;

int d(int a, int b){ // 거리계산
    return abs(px[a] - px[b]) + abs(py[a] - py[b]);
}

int getSum(int a, int b){ // 재귀 어떤로직??
    // 기저사례: 모든사건 해결??
    if(a == w + 1 || b == w + 1) return 0;
    if(dp[a][b]) return dp[a][b];
    //다음 사건 가리킨다.
    int next = max(a, b) + 1;
    // 경찰차 2가 해결, 경찰차 1이 해결
    return dp[a][b] = min(getSum(a, next) + d(b, next), getSum(next, b) + d(a, next));
}

void solve(){ // trace 누가 해결했는지!!
    int a = 0, b = 1;
    for(int i = 2; i < w + 2; i++){
        if(dp[i][b] + d(a, i) < dp[a][i] + d(b, i)) puts("1"), a = i;
        else puts("2"), b = i;
    }
    return;
}

int main(){
    cin >> n >> w;
    // 경찰차 위치
    px[0] = 1, py[0] = 1; // 경찰차 1
    px[1] = n, py[1] = n; // 경찰차 2
    // 사건의 위치
    for(int i = 2; i < w + 2; i++){
        scnaf("%d %d", &y, &x);
        px[i] = x, py[i] = y;
    }
    // 왜 0이랑 1부터 들어가지?? -> 경찰차의 초기위치 0이랑 1이니깐
    printf("%d\n", getSum(0, 1));
    solve();
    return 0;
}