#include<bits/stdc++.h>
using namespace std;
int cnt, mcnt, jcnt;
string s;
bool check(char a){
    return (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u');
}
int main(){
    while(true){
        cin >> s;
        if(s == "end") break;
        bool flag = 0;
        cnt = mcnt = jcnt = 0;
        char prev = '1';
        for(char a : s){
            if(check(a)) cnt++, mcnt++, jcnt = 0;
            else jcnt++, mcnt = 0;
            if(mcnt == 3 || jcnt == 3) flag = 1;
            if(prev != '1' && a == prev && a != 'e' && a != 'o') flag = 1;
            prev = a;
        }
        if(cnt == 0) flag = 1;
        if(flag) cout <<"<" << s << "> is not acceptable.\n";
        else cout << "<" << s << "> is acceptable.\n";
    }
    return 0;
}