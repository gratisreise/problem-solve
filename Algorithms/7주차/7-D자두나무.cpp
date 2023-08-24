#include<bits/stdc++.h>
using namespace std;
int dp[1004][2][34], n, m, b[1004];
// 자두 떨어지는 위치, 현재위치, 남은 이동횟수
int go(int idx, int tree, int cnt){
    if(cnt < 0) return -1e9; // 불가능한 경우에 max후보 제외
    if(idx == n) return 0; // 0 ~ n-1이니깐 n일 때 리턴 0
    // 밑에거는 반드시 w번 이동해야 return
    // if(idx == n) return cnt == 0 ? 0 : -1e9;

    // 메모이제이션
    int &ret = dp[idx][tree][cnt];
    if(~ret) return ret; // ret에 값이 있으면??

    // 0 ^ 1 -> 토글 가능
    // ^로 트리이동, 움직이는 경우 안 움직이는 경우
    // 마지막으로 현재 인덱스에서 자두가 떨어지는지 체크해서 더하기
    return ret = max(go(idx + 1, tee^1, cnt - 1), go(idx + 1, tree, cnt)) + (tree == b[idx] - 1);
}
int main(){
    memset(dp, -1, sizeof(dp));
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> b[i];
    // 이동하고 들어가고, 이동 안하고 들어가기 구분
    cout << max(go(0, 1, m - 1), go(0, 0, m)) << '\n';
    return 0;
} 
/*
0 과 1로 받은 이유는 던 간단한 코드작성이 가능해지기 때문에
*/