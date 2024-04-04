#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, m, a[300004], ret = 1e18;
bool check(ll mid){
    ll num = 0;
    for(int i = 0; i < m; i++){
        num += a[i] / mid;
        if(a[i] % mid) num++;
    }
    return n >= num;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    ll lo = 1, hi = 1, mid;
    for(int i = 0; i < m; i++) cin >> a[i], hi = max(hi, a[i]);
    while(lo <= hi){
        mid = (lo + hi) / 2;
        if(check(mid)){
            ret = min(ret, mid);
            hi = mid - 1;
        }else lo = mid + 1;
    }
    cout << ret << '\n';
}