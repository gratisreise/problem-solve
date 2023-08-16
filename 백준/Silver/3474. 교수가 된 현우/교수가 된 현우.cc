#include<bits/stdc++.h>
using namespace std;
string s;
int t, n, cnt2, cnt5;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> t;
    while(t--){
        cin >> n;
        cnt2 = cnt5 = 0;
        for(int i = 2; i <= n; i *= 2){
            cnt2 += n / i;
        }
        for(int j = 5; j <= n; j *= 5){
            cnt5 += n / j;
        }
        cout << min(cnt2, cnt5) << '\n';
    }
}