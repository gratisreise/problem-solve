#include <bits/stdc++.h>
using namespace std;
string s,temp;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> s;
    temp = s;
    reverse(temp.begin(), temp.end());
    if(temp == s) cout << 1 << '\n';
    else cout << 0 << '\n'; 
    return 0;
}