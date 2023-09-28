#include<bits/stdc++.h>
using namespace std;
#define MAX_N 100001
int dp[5][5][MAX_N], n;
vector<int> v;
int check(int from, int to){
    // 중앙에서 이동
    if(from == 0) return 2;
    // 다시 누르기
    if(from == to) return 1;
    // 반대
    if(abs(from - to) == 2) return 4;
    // 인접
    return 3;
}

int solve(int y, int x, int target){
    // 
    if(target == n) return 0;
    //겹치는 부분문제 있으면 그 dp값을 리턴
    if(dp[y][x][target] != -1) return dp[y][x][target];

    int left = solve(v[target], x, target + 1) + check(y, v[target]);
    int right = solve(y, v[target], target + 1) + check(x, v[target]);
    return dp[y][x][target] = min(left, right);
}

int main(){
    while(true){
        int num;
        cin >> num;
        if(num == 0) break;
        v.push_back(num);
    }
    // 초기화
    memset(dp, -1, sizeof(dp));
    n = v.size();
    cout << solve(0, 0, 0) << '\n';
    return 0;
}