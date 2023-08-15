#include<bits/stdc++.h>
using namespace std;
int m; string s, ret;
vector<string> v;
bool cmp(string a, string b){
    if(a.size() == b.size()) return a < b;
    return a.size() < b.size();
}
void go(){
    while(ret.size() && ret.front() == '0'){
        ret.erase(ret.begin());
    }
    if(ret.empty()) ret = "0";
    v.push_back(ret);
    ret = "";
}
int main(){
    cin >> m;
    while(m--){
        cin >> s;
        for(char a : s){
            if(a < 65) ret += a;
            else if(ret.size()) go();
        }
        if(ret.size()) go();
    }
    sort(v.begin(), v.end(), cmp);
    for(string s : v) cout << s << '\n';
}