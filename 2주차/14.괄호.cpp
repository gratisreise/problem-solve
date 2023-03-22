#include<bits/stdc++.h>
using namespace std;
int t;
string s;
bool check(string s){
    stack<char> stk;
    for(char c : s){
        if(c == '(') stk.push(c);
        else{
            if(!stk.empty()) stk.pop();
            else return false;
        }
    }
    return stk.empty();
}
int main(){
    cin >> t;
    while(t--){
        cin >> s;
        if(check(s)) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}
/*
stk.empty()는 stack이 비어있으면 true 아니면 false를 반환
!stk.empty()는 stack이 비어있지 않다는 것을 나타냄
짝짓기는 stack로직 반드시 생각!!!!
*/