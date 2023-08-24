#include<bits/stdc++.h>
using namespace std;
vector<string> cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
string s;
int main(){
    cin >> s;
    for(string ss : cro){
        while(1){
            int idx = s.find(ss);
            if(idx == string::npos) break;
            s.replace(idx, ss.length(), "#");
        }
    }
    cout << s.length() << '\n';
}