#include<bits/stdc++.h>
using namespace std;
int m;
string s, ret;
vector<string> v;
void go(){
    while(ret.size() && ret.front() == '0'){
        ret.erase(ret.begin());
    }
    if(ret.size() == 0) ret = "0";
    v.push_back(ret);
    ret = "";
}
bool cmp(string a, string b){
    if(a.size() == b.size()) return a < b;
    return a.size() < b.size();
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
    for(string i : v) cout << i << "\n";
}
/*
front(), go() 함수로 제어
*/

//이거 왜 안돼지?? -> 최대 100글자 최대 100자리 숫자
#include<bits/stdc++.h>
using namespace std;
string s, ret;
int n;
vector<int> v;
int main(){
    cin >> n;
    while(n--){
        cin >> s;
        string ret = "";
        for(int i = 0; i < s.size(); i++){
            if(s[i] < 65) ret += s[i];
            else if(ret.size() && s[i] >= 65){
                    v.push_back(atoi(ret.c_str()));
                    ret = "";
                }
        }
        if(ret.size()) v.push_back(atoi(ret.c_str()));
    }
    sort(v.begin(), v.end());
    for(int i : v) cout << i << '\n';
}