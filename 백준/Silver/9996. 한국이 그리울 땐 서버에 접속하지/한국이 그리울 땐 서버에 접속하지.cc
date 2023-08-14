#include <bits/stdc++.h>
using namespace std;
int n;
string s,pre,suf,s1;
char mid;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> s;
    pre=s.substr(0,s.find("*"));
    suf=s.substr(s.find("*")+1);
    for(int i = 0; i < n; i++){
        cin >> s1;
        if(s1.size()<pre.size() + suf.size()) cout <<"NE\n";
        else{
            if(s1.substr(0,pre.size()) == pre && s1.substr(s1.size() - suf.size()) == suf) cout << "DA\n";
            else cout << "NE\n";
        }
    }
    return 0;
}