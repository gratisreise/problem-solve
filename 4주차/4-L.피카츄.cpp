#include<bits/stdc++.h>
using namespace std;
string s;
bool flag = 0; // pikachu못하면 체크 -> 최종순간 체크 if 과정에서 체크하고 정하기 flag
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> s;
    for(int i = 0; i < s.size(); i++){
        if(i < s.size() - 1 && s.substr(i, 2) == "pi" || s.substr(i, 2) == "ka") i += i;
        else if(i < s.size() - 2 && s.substr(i, 3) == "chu") i += 2;
        else flag = 1;
    }
    if(flag) cout << "NO\n";
    else cout << "YES\n";
    return 0;
}