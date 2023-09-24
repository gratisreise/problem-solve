#include<bits/stdc++.h>
using namespace std;
int n, m, c, y, x, a[51][51], dp[51][51][51][51];
const int mod = 1000007;
// 시작점, 방문하는 오락실 수, prev는 이전에 방문한 오락실번호
int go(int y, int x, int cnt, int prev){
    if(y > n || x > m) return 0; //범위 벗어나면 배제
    if(y == n && x == m){ // 목적지 도착했을 때
        //오락실0 도착점에 오락실 없으면 1리턴
        if(cnt == 0 && a[y][x] == 0) return 1;
        //오락실 남아있고 도착점이 prev보다 크면
        if(cnt == 1 && a[y][x] > prev) return 1;
        return 0;
    }

    //메모이제이션
    int &ret = dp[y][x][cnt][prev];
    if(ret != -1) return ret;

    //로직
    ret = 0;
    if(a[y][x] == 0) //오락실이 없으면
        //  y + 1 or x + 1 이동표현, 모듈러 연산 정수론
        ret = (go(y + 1, x, cnt, prev) + go(y, x + 1, cnt, prev)) % mod;
    else if(a[y][x] > prev) // 오락실0, 이전보다 크면
        //오락실 갯수 -1, 이전 방문 오락실 번호 저장하고 ㄱㄱ
        ret = (go(y + 1, x, cnt - 1, a[y][x]) + go(y, x + 1, cnt - 1, a[y][x])) % mod;
    return ret;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    memset(dp, -1, sizeof(dp));
    cin >> n >> m >> c;
    // 번호 정해주기
    for(int i = 1; i <= c; i++){
        cin >> y >> x;
        a[y][x] = i;
    }
    // 오락실 개수마다 방문경로 체크
    for(int i = 0; i <= c; i++){
        cout << go(1, 1, i, 0) << " ";
    }
    return 0;
}
/*
1. dp 선언할 때 prev는 왜?
2. 재귀형식으로 들어가는 방법의 로직 부분

*/