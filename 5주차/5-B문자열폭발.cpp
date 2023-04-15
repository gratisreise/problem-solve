#include <bits/stdc++.h>
using namespace std;
string S, T, ret;
int main() {
    cin >> S >> T;
    for(char a : S){
        ret += a;
         
        if(ret.size() >= T.size() && ret.substr(ret.size() - T.size(), T.size()) == T){
            ret.erase(ret.end() - T.size(), ret.end()); 
        }
    }
    if(!ret.size())cout << "FRULA" << "\n";
    else cout << ret << "\n";
    return 0;
}
// 문자열 먼저 집어넣고 생각하기
// erase는 포인터 
#include <bits/stdc++.h>
using namespace std;
string S, T, ret;
stack<char> stk; 
int main() {
    cin >> S >> T;
    for(char a : S){ 
        stk.push(a); 
        // 스택 가장 위 문자가 문자열 T의 끝 글자와 같다면 , 비교할 때 사이즈 체크 중요
        if(stk.size() >= T.size() && stk.top() == T[T.size() - 1]){
            //문자열이 t와 같은지 검사
            string ss = "";
            for(char i : T){
                // ss += stk.top();
                stk.pop();
            }
            reverse(ss.begin(), ss.end());
            if(T != ss){
                for(int i : ss){
                    stk.push(i);
                }
            }
        }  
    }    
    if(!stk.size()){
        cout << "FRULA\n";
    }else{
        //스택에서 뽑아내서 문자열 만들기
        while(stk.size()){
            ret += stk.top(); stk.pop();
        }
        reverse(ret.begin(), ret.end()); 
        cout << ret << "\n";
    }
    return 0;
} 