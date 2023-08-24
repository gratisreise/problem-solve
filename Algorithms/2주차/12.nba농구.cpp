#include<bits/stdc++.h>
using namespace std;
#define prev noah
int A, B, asum, bsum, t, n;
string s, prev;
string print(int a){
    string d = "00" + to_string(a / 60);
    string e = "00" + to_string(a % 60);
    return d.substr(d.size() - 2, d.size()) + ":" + e.substr(e.size() - 2, e.size());
}
int change(string s){
    return atoi(s.substr(0, 2).c_str()) * 60 + atoi(s.substr(3, 2).c_str());
}
void go(int &sum, string s){
    sum += change(s) - change(prev);
}
int main(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> t >> s;
        if(A > B) go(asum, s);
        if(B > A) go(bsum, s);
        t == 1 ? A++ : B++;
        prev = s;
    }
    if(A > B) go(asum, "48:00");
    if(B > A) go(bsum, "48:00");
    cout << print(asum) << '\n';
    cout << print(bsum) << '\n';
}
/*
1. prev
2. 시/분/초 작은 단위로 통일해서 계산하는게 좋음
3. 끝점과 계산
4. 00으로 앞의 0맞추기
5. prev는 디파인 이용하는거 필수
6. to_string();
7. 시점에 따른 조건의 변환
8. 
*/