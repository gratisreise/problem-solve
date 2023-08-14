#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int t, n;
string a, b;
int main(){
    cin >> t;
    while(t--){
        cin >> n;
        map<string, int> mp;
        for(int i = 0; i < n; i++) cin >> a >> b, mp[b]++;
        ll ret = 1;
        for(auto c : mp) ret *= (ll)(c.second + 1);
        ret--;
        cout << ret << '\n';
    }
}