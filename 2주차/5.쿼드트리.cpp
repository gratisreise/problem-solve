#include <bits/stdc++.h>
using namespace std;
int n;
string s;
char a[101][101]; // 개별 char형으로 받아서 함수 생성해주기 위해
string quard(int y, int x, int n){
    if(n == 1) return string(1, a[y][x]); //기저사례 + 캐릭터를 스트링으로 바꾸는 함수
    char b = a[y][x]; // char 
    string ret = ""; // 빈문자열로 초기화
    for(int i = y; i < y + n; i++){  // 분할정복 개념들어감
        for(int j = x; j < x + n; j++){
            if(b != a[i][j]){ // 같은 문자가 아닌게 있으면 바로 쪼개기
                ret += '(';
                ret += quard(y, x, n / 2); //왼쪽 위 
                ret += quard(y, x + n / 2, n / 2); // 오른쪽 위
                ret += quard(y + n / 2, x, n / 2); // 왼쪽 아래
                ret += quard(y + n / 2, x + n / 2, n / 2); // 오른쪽 아래
                ret += ')';
                return ret;
            }
        }
    }
    return string(1, a[y][x]); // 모두다 같은 문자일 때
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> a[i][j];
        }
    }
    cout << quard(0, 0, n) << '\n';
    return 0;
}
/*
영상이 모두 0이면 0, 모두 1이면 1을 출력한다.
쿼드트리구조로 재귀가 호출될 때 나눠진 포인트의 순서를 잘못하면
함수가 종료되는 순서가 달라져 다른 결과가 나온다.
*/