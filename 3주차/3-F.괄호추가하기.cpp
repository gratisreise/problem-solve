#include <bits/stdc++.h>
using namespace std; 

vector<int> num; 
vector<char> oper_str; 
int n, ret = -1e9;
string s;

int oper(char a, int b, int c){ // 진짜 연산자로 바꿔주는 작업
    if(a == '+') return b + c; 
    if(a == '-') return b - c; 
    if(a == '*') return b * c;  
} 

void go(int here, int _num){ // 계산순서 변경해주는 작업
    if(here == num.size() - 1){  // 기저사례 마지막 도달
        ret = max(ret, _num); 
        return;
    }  
    go(here + 1, oper(oper_str[here], _num, num[here + 1]));// 재귀

    if(here + 2 <= num.size() - 1){ // 오버플로우 체크
        int temp = oper(oper_str[here + 1], num[here + 1], num[here + 2]); 
        go(here + 2, oper(oper_str[here], _num, temp));  
    }
    return;
} 

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> s; 
    for(int i = 0; i < n; i++){
        if(i % 2 == 0) num.push_back(s[i] - '0'); 
        else oper_str.push_back(s[i]);
    } 
    go(0, num[0]);  
    cout << ret << "\n";
    return 0;
} 
/*
1.누적합 개념이용 -> 도구 = 재귀를 이용
2.연산자, 숫자 구분
구간합을 이용한 경우읭 수 구하기

*/