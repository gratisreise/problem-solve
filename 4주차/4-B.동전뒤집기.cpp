#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, ret = INF, a[44];
string s;
// 재귀를 통해 뒤집기 여부 경우의 수 나누고, 기저사례에서 열의 뒤집기 실행
void go(int here){ 
    if(here == n + 1){// 모든 행을 확인한 경우
        int sum = 0;
        for(int i  = 1; i <= (1 << (n - 1)); i *= 2){ // 비트마스킹을 된 각 행을 표현 함
            int cnt = 0; //동전의 앞면 갯수 카운팅
            for(int j = 1; j <= n; j++){ 
                if(a[j] & i) cnt++; // i번째 경우에서 앞면인 동전의 개수를 세서 cnt에 저장
            }
            sum += min(cnt, n - cnt); // 앞뒤면중 작은수를 선택하므로 뒤집는 행위랑 같음
        }
        ret = min(ret, sum); // 가능한 모든 경우에서 뒷면인 동전의 개수를 최소화한 값을 ret에 저장
        return;
    }
    go(here + 1); // 재귀 홍출
    a[here] = ~a[here]; // 뒤집고
    go(here + 1);  //호출 
}

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 1; i <= n; i++){ //a배열 1부터 배열설정
        cin >> s; // 한 줄의 문자열을 입력 받습니다
        int value = 1; // 각 동전의 앞면(T)에 해당하는 비트값을 의미합니다.
        for(int j = 0; j < n; j++){// 각 자리에서 T를 1로 취급하고 넣어줌
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