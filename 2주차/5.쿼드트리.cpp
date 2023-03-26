#include <bits/stdc++.h>
using namespace std;
int n;
string s;
char a[101][101]; // 개별 char형으로 받아서 함수 생성해주기 위해
string quard(int y, int x, int size){
    if(size == 1) return string(1, a[y][x]); //기저사례 + 캐릭터를 스트링으로 바꾸는 함수
    char b = a[y][x]; // char 
    string ret = ""; // 빈문자열로 초기화
    for(int i = y; i < y + size; i++){  // 분할정복 개념들어감
        for(int j = x; j < x + size; j++){
            if(b != a[i][j]){ // 같은 문자가 아닌게 있으면 바로 쪼개기
                ret += '(';
                ret += quard(y, x, size / 2); //왼쪽 위 
                ret += quard(y, x + size / 2, size / 2); // 오른쪽 위
                ret += quard(y + size / 2, x, size / 2); // 왼쪽 아래
                ret += quard(y + size / 2, x + size / 2, size / 2); // 오른쪽 아래
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
        cin >> s;
        for(int j = 0; j < n; j++){
            a[i][j] = s[j];
        }
    }
    cout << quard(0, 0, n) << '\n';
    return 0;
}