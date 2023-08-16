#include<bits/stdc++.h>
using namespace std;
int t;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> t;
    for(int i = 0; i < t; i++){
        cin >> s;
        stack<char> stk;
        for(char a : s){
            if(stk.size() && stk.top() == '(' && a == ')') stk.pop();
            else stk.push(a);
        }
        if(stk.size()) cout << "NO\n";
        else cout << "YES\n";
    }
}