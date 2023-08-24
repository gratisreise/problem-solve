#include<bits/stdc++.h>
using namespace std;
int k, n, ret = 0;
stack<int> stk;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> k;
    while(k--){
        cin >> n;
        if(stk.size() && n == 0) stk.pop();
        else stk.push(n);
    }
    if(!stk.size()) cout << 0 << '\n';
    else{
        while(stk.size()){
            ret += stk.top(); stk.pop();
        }
        cout << ret << '\n';
    }
    
}
/*
스택에 저장하고 조건이될 때마다 팝을해서 
스택사이즈 있으면 사이즈만큼 top pop 해주면서 ret에 합하기
*/