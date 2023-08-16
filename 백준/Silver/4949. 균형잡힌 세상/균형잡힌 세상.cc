#include<bits/stdc++.h>
using namespace std;
int n;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    while(true){
        getline(cin, s);
        if(s == ".") break;
        stack<char> stk;
        bool flag = true;
        for(char a : s){
            if(a == ')'){
                if(stk.size() == 0 || stk.top() == '['){
                    flag = false; break;
                }else stk.pop();
            }
            if(a == ']'){
                if(stk.size() == 0 || stk.top() == '('){
                    flag = false; break;
                }else stk.pop();
            }
            if(a == '(' || a == '[') stk.push(a);
        }
        if(flag && stk.size() == 0) cout << "yes\n";
        else cout << "no\n";
    }
    return 0;
}