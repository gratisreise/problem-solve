// 큰돌의 풀이
// 짝짓기의 조건을 벡터에 집어넣고 순회하면서 맞으면 대체하는 아이디어
#include <bits/stdc++.h>
using namespace std;
vector<string> cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    cin>>s;
    for(int i = 0; i < cro.size(); i++){
        while(1){
            int idx = s.find(cro[i]);
            if(idx == string::npos) break;
            s.replace(idx, cro[i].length(), "#");
        }
    }
    cout << s.length() << "\n";
}

// 내풀이
// 문자열 자체를 순회하면서 다른 문자열에 넣어주고 그 문자열이 조건이 맞을 때마다
// 대체해주는 아이디어
#include<bits/stdc++.h>
using namespace std;
string s, ret;
bool check1(string s){
    if(s.substr(s.size() - 2) == "c=") return 1;
    else if(s.substr(s.size() - 2) == "c-") return 1;
    else if(s.substr(s.size() - 2) == "d-") return 1;
    else if(s.substr(s.size() - 2) == "lj") return 1;
    else if(s.substr(s.size() - 2) == "nj") return 1;
    else if(s.substr(s.size() - 2) == "s=") return 1;
    else if(s.substr(s.size() - 2) == "z=") return 1;
    else return 0;
}
bool check2(string s){
    if(s.substr(s.size() - 3) == "dz=") return 1;
    else return 0;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> s;
    for(char a : s){
        ret += a;
        if(ret.size() >= 3 && check2(ret)){
            ret.erase(ret.end() - 3, ret.end());
            ret += '1';
        }
        if(ret.size() >= 2 && check1(ret)){
            ret.erase(ret.end() - 2, ret.end());
            ret += '1';
        }
    }
    cout << ret.size() << '\n';
}