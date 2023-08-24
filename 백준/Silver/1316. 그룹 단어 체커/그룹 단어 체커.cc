#include<bits/stdc++.h>
using namespace std;
int n, ret, cnt[200];
string s;
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s;
        stack<char> stk;
        fill(cnt, cnt + 200, 0);
        for(char a : s){
            if(stk.size() && stk.top() != a && cnt[a] > 0) continue;
            else stk.push(a), cnt[a]++;
        }
        if(stk.size() == s.size()) ret++;
    }
    cout << ret << '\n';
}