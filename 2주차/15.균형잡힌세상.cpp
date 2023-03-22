#include<bits/stdc++.h>
using namespace std;
int n;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    while(true){ 
        string s; 
        getline(cin, s); // 띄어쓰기가 있으므로 getline 사용
        if(s == ".") break; // 온점이 종료 조건
        stack<int> stk; // 테스트 케이스마다 스택 새로 만듬 중요!!
        bool check = true; // 
        for(int i = 0; i < s.length(); i++){ //s의 길이 만큼 돈다
            if(s[i] == ')'){ 
                if(stk.size() == 0 || stk.top() == '['){ // 사이즈 0이고 탑이면 false임
                    check = false; 
                    break;
                }else{
                    stk.pop();
                }
            }
            if(s[i] == ']'){
                if(stk.size() == 0 || stk.top() == '('){
                    check = false; 
                    break; 
                }else{
                    stk.pop();
                }
            } 
            if(s[i] == '(') stk.push(s[i]);
            if(s[i] == '[') stk.push(s[i]); 
        }  
        if(check && stk.size() == 0)  cout << "yes\n";
        else cout << "no\n";
    } 

    return 0;
}