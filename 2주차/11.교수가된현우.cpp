#include<bits/stdc++.h>
using namespace std;
#define prev kundol // prev를 쓸려면 이걸로 선언
int n, o, A, B, asum, bsum; 
string s, prev;
string print(int a){ // 초의 분 변환 
    string d = "00" + to_string(a / 60); //포멧터 변환 "00" 더하기로 09만들기
    string e = "00" + to_string(a % 60); //
    return d.substr(d.size() - 2, 2) + ":" + e.substr(e.size() - 2, 2); //어차피 0 아닌가???
}
int chageToInt(string a){ //분을 초로 변환
    return atoi(a.substr(0, 2).c_str()) * 60 + atoi(a.substr(3, 2).c_str());
}
void go(int &sum, string s){ // 초로변환된 걸 계산하기
    sum += (changeToInt(s) - changeToInt(prev));
}
int mian(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    while(n--){ // 
        cin >> o >> s;
        if(A > B) go(asum, s);
        else if(B > A) go(bsum, s); 
        o == 1 ? A++ : B++; //골 넣으걸 통해 구하기
        prev = s; // 이전에 받은걸 사용하기위해
    }
    if(A > B) go(asum, "48:00"); //끝점 계산
    else if(B > A) go(bsum, "48:00");
    cout << print(asum) << '\n';
    cout << print(bsum) << '\n';
    return 0;
}