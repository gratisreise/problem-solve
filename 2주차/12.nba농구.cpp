#include<bits/stdc++.h>
using namespace std;
#define prev Noah // define 필수!!!
int n, o, A, B, asum, bsum; //
string s, prev; //
string print(int a){ // 초 - > 분, 00포멧 맞춰주기
    string d = "00" + to_string(a / 60); 
    string e = "00" + to_string(a % 60); 
    return d.substr(d.size() - 2, 2) + ":" + e.substr(e.size() - 2, 2); 
}
int changeToInt(string a){// 분 - > 초로 바꿔주는 것
    return atoi(a.substr(0, 2).c_str()) * 60 + atoi(a.substr(3, 2).c_str());
}
void go(int &sum, string s){ //직전과 비교해서 빼기 해주는 함수
    sum += (changeToInt(s) - changeToInt(prev)); 
}
int main(){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); cout.tie(NULL); 
    cin >> n; 
    for(int i = 0; i < n; i++){
        cin >> o >> s; 
        if(A > B)go(asum, s);
        else if(B > A)go(bsum, s);
		o == 1 ? A++ : B++; //삼항 연산자 ?는 if :는 else
        prev = s; //prev이용해서 직전과 비교
    } 
    if(A > B)go(asum, "48:00");
    else if(B > A)go(bsum, "48:00"); 
    cout << print(asum) << "\n"; 
    cout << print(bsum) << "\n";
}
/*
1. prev
2. 시/분/초 작은 단위로 통일해서 계산하는게 좋음
3. 끝점과 계산
4. 00 포멧 맞추기
5. prev는 디파인 이용하는거 필수
*/