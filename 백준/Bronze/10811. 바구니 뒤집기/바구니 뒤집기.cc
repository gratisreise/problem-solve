#include<bits/stdc++.h>
using namespace std;
vector<int> v;
int n, m, a, b;
int main(){
    cin >> n >> m;
    for(int i = 1; i <= n; i++) v.push_back(i);
    while(m--){
        cin >> a >> b; a--;
        reverse(v.begin() + a, v.begin() + b);
    }
    for(int i : v) cout << i << ' ';
}