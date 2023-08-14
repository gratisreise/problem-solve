#include<bits/stdc++.h>
using namespace std;
int n, m;
map<string, int> mp;
string s, a[100004];
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> s;
        mp[s] = i + 1;
        a[i + 1] = s;
    }
    for(int i = 0; i < m; i++){
        cin >> s;
        if(atoi(s.c_str())) cout << a[atoi(s.c_str())] << '\n';
        else cout << mp[s] << '\n';
    }
}