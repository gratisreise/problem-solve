#include<bits/stdc++.h>
using namespace std;
string s;
int n, temp;
stack<int> stk;
void check(string s){
    if(s == "push") stk.push(temp);
    else if(s == "pop"){
        if(stk.size()){
            cout << stk.top()<< '\n';
            stk.pop();
        }
        else cout << -1 << '\n';
    }
    else if(s == "size") cout << stk.size() << '\n';
    else if(s == "empty"){
        if(stk.empty()) cout << 1 << '\n';
        else cout << 0 << '\n';
    }
    else if(s == "top"){
        if(stk.size()) cout << stk.top() << '\n';
        else cout << -1 << '\n';
    }
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s; if(s == "push") cin >> temp;
        check(s);
    }
}