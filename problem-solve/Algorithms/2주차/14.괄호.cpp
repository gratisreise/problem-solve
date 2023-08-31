#include<bits/stdc++.h>
using namespace std;
int t;
string s;
bool check(string s){
    stack<char> stk;
    for(char c : s){
        if(c == '(') stk.push(c);
        else{ // 다른 괄호가 왔다는거네..
            if(!stk.empty()) stk.pop(); //비어있지 않다면 팝
            else return false; // 비어있다면 NO의 예시니깐 false
        }
    }
    return stk.empty(); // 마지막 재확인??
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
// 다른 풀이
int main(){
    cin >> t;
    while(t--){
        cin >> s;
        stack<char> stk;
        for(char a : s){
            if(stk.size() && stk.top() == '(' && a == ')') stk.pop();
            else stk.push(a);
        }
        if(stk.empty()) cout << "YES\n";
        else cout << "NO\n";
    }
}
/*
stk.empty()는 stack이 비어있으면 true 아니면 false를 반환
!stk.empty()는 stack이 비어있지 않다는 것을 나타냄
짝짓기는 stack로직 반드시 생각!!!!
*/