#include <bits/stdc++.h>
using namespace std;
string s;
int lcnt, vcnt;
bool isVowel(int idx){
    return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u');
}
int main(){
    while(true){
        cin >> s;
        if(s == "end") break;
        lcnt = vcnt = 0; // 자음, 모음
        bool flag = 0; // 최종확인
        bool is_include_v = 0; //모음 한 개 이상 불리언
        int prev = -1;
        for(int i = 0; i < s.size(); i++){
            int idx = s[i]; // int형을 설정
            if(isVowel(idx)) lcnt++, vcnt = 0, is_include_v = 1; // 모음++ ,자음 0, 모음있나 체크
            else vcnt++, lcnt = 0; // 자음체크 모음 0
            if(vcnt == 3 || lcnt == 3) flag = 1; // 자,모 3개 연속 이면 not
            if(i >= 1 && (prev == idx) && (idx != 'e' && idx != 'o')){ 
                flag = 1; //모음 두개연속이면 낫
            }
            prev = idx; // 배열의 이전 요소와 쉽게 비교하기위해
        }
        if(is_include_v == 0) flag = 1;
        if(flag) cout << "<" << s << "> is not acceptable.\n";
        else cout << "<" << s << "> is acceptable.\n";
    }
    return 0;
}