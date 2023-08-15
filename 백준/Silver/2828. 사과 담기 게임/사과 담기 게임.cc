#include<bits/stdc++.h>
using namespace std;
int l, r, a, m, n, j, ret;
int main(){
    cin >> n >> m >> j;
    l = 1;
    while(j--){
        r = l + m - 1;
        cin >> a;
        if(l <= a && a <= r) continue;
        if(a < l) ret += l - a, l = a;
        else ret += a - r, l += a - r;
    }
    cout << ret << '\n';
}