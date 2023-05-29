#include<bits/stdc++.h>
using namespace std;
int t, n, cnt5, cnt2, ret;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> n;
        cnt5 = cnt2 = ret = 0;
        for(int i = 2; i <= n; i *= 2) cnt2 += (n / i);
        for(int i = 5; i <= n; i *= 5) cnt5 += (n / i);
        ret = min(cnt2, cnt5);
        cout << ret << '\n';
    }
}


