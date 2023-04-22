#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, ret = INF, a[44];
string s;
// 동전순회하면서 앞뒤 뒤집는 작업, 재귀호출하여 동전들이 뒤집히는 모든 경우 체크
void go(int here){ 
    if(here == n + 1){// 모든 행을 확인하는 경우
        int sum = 0;
        for(int i  = 0; i <= (1 << (n - 1)); i *= 2){ // 가능한 모든 열의 경우를 확인
            int cnt = 0;
            for(int j = 1; j <= n; j++) if(a[j] & i) cnt++; // i번째 경우에서 앞면인 동전의 개수를 세서 cnt에 저장
            sum += min(cnt, n - cnt); // 이번 경우에서 뒷면인 동전의 개수가 더 적은 경우를 선택하여 더함
        }
        ret = min(ret, sum); // 가능한 모든 경우에서 뒷면인 동전의 개수를 최소화한 값을 ret에 저장
        return;
    }
    go(here + 1); // 
    a[here] = ~a[here]; //동전뒤집기 
    go(here + 1); 
}

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 1; i <= n; i++){ //문자열을 비트마스크로 변환
        cin >> s; // 한 줄의 문자열을 입력 받습니다. 예를 들어, "THHHTT"와 같은 형태로 입력됩니다.
        int value = 1; // 각 동전의 앞면(T)에 해당하는 비트값을 의미합니다.
        for(int j = 0; j < s.size(); j++){// 2차 -> 1차로 줄임
            if(s[j] == 'T') a[i] |= value; // 문자열에서 'T'가 나오면, 해당 비트를 1로 설정합니다.
            value *= 2; // 다음 동전의 비트값을 계산하기 위해 2배씩 증가시킵니다.
        }
    }
    go(1); //왜 1??
    cout << ret << '\n';
}
/*
1. 각 행을 2진수로 바꿔서 배열 a[]에 저장
2. 재귀로 탐색하면서 확인
*/