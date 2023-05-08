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