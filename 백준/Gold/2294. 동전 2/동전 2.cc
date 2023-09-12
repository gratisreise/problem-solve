#include<bits/stdc++.h>
using namespace std;
int n, k, dp[10001], coin, INF = 1e9;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> n >> k;
    fill(dp, dp + 10001, INF);
    dp[0] = 0;
    for(int i = 0; i < n; i++){
        cin >> coin;
        if(coin >= 10001) continue;
        for(int j = coin; j <= k; j++){
            dp[j] = min(dp[j], dp[j - coin] + 1);
        }
    }
    if(dp[k] == INF) cout << -1 << '\n';
    else cout << dp[k] << '\n';
    return 0;
}