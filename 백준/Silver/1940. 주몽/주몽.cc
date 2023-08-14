#include<bits/stdc++.h>
using namespace std;
int n, m, a[15004], ret;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; i++) cin >> a[i];
    if(m > 200000) cout << 0 << '\n';
    else{
        for(int i = 0; i < n;  i++){
            for(int j = 0; j < i; j++){
                if(a[i] + a[j] == m) ret++;
            }
        }
        cout << ret << '\n';
    }

}