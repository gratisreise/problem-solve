#include <bits/stdc++.h>
using namespace std;
string string_add(string a, string b){
    int sum = 0;
    string ret;
    while(a.size() || b.size() || sum){
        if(a.size()){
            sum += a.back() - '0';
            a.pop_back();
        }
        if(b.size()){
            sum += b.back() - '0';
            b.pop_back();
        }
        ret += (sum % 10) + '0';
        sum /= 10;
    }
    reverse(ret.begin(), ret.end());
    return ret;
}
string a, b;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> a >> b;
    cout << string_add(a, b) << '\n';
    return 0;
}