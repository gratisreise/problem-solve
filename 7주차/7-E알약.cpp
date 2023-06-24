#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, dp[31][31];
ll go(int whole, int half){
    // 기저사례
    if(whole == 0 && half == 0) return 1; 
    if(dp[whole][half]) return dp[whole][half];
    
    // 메모이제이션
    ll &ret = dp[whole][half]; 

    //로직
    if(whole > 0) ret += go(whole - 1, half + 1); 
    if(half > 0) ret += go(whole, half - 1);
    return ret;   
}
int main(){ 
    while(true){
        cin >> n; 
        if(n == 0)break;
        cout << go(n, 0) << "\n";
    }
    return 0;
}