#include<bits/stdc++.h>
using namespace std;
int dp[1000004], n;
const int INF = 1e9;
void go(int n){
    if(n == 0) return;
    cout << n << ' ';
    if(n % 3 == 0 && dp[n] == (dp[n / 3] + 1))
        go(n / 3);
    else if(n % 2 == 0 && dp[n] == (dp[n / 2] + 1))
        go(n / 2);
    else if(n - 1 >= 0 && dp[n] == (dp[n - 1] + 1))
        go(n - 1);
    return;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n;
    fill(dp, dp + 1000004, INF);
    dp[1] = 0;
    for(int i = 1; i <= n; i++){
        if(!(i % 3)) dp[i] = min(dp[i / 3] + 1, dp[i]);
        if(!(i % 2)) dp[i] = min(dp[i / 2] + 1, dp[i]);
        dp[i] = min(dp[i - 1] + 1, dp[i]);
    }
    cout << dp[n] << '\n';
    go(n);
    return 0;
}