#include<bits/stdc++.h>
using namespace std;
int n;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    while(true){ 
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

#include<bits/stdc++.h>
using namespace std;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    while(1){
        getline(cin, s);
        if(s == ".") break;
        stack<char> stk;
        bool flag = 1;
        for(char a : s){
            if(a == ')' || a == ']'){
                if(a == ')' && stk.size() && stk.top() == '(') stk.pop();
                if(a == ']' && stk.size() && stk.top() == '[') stk.pop();
                else {flag = 0; break;}
            }
            else if(a == '(' || a == '[') stk.push(a);
        }
        if(flag && stk.empty()) cout << "yes\n";
        else cout << "no\n";
    }
}//tc는 통과했는데 뭐지?? 반례가 존재 한다.
#include<bits/stdc++.h>
using namespace std;
string s;
int main(){
    while(1){
        getline(cin, s);
        if(s == ".") break;
        stack<char> stk;
        for(char a : s){
            if(a == '[' || a == '(') stk.push(a);
            if(a == ')'){
                if(stk.size() && stk.top() == '(') stk.pop();
                else stk.push(a);
            }
            if(a == ']'){
                if(stk.size() && stk.top() == '[') stk.pop();
                else stk.push(a);
            }
        }
        if(stk.empty()) cout << "yes\n";
        else cout << "no\n";
    }   
}