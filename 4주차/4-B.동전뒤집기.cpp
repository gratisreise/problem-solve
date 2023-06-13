#include<bits/stdc++.h>
using namespace std;
int n, ret = 1e9, a[44]; string s;
// 동전 뒤집기 + 재뒤집 표현
void go(int here){
    if(here == n + 1){
        int sum = 0;
        for(int i =  1; i <= (1 << (n - 1)); i *= 2){ // 2^0~2^(n-1) 각열 표현
            int cnt = 0; 
            for(int j = 0; j < n; j++){ // 각 행 체크
                if(a[j] & i) cnt++; // 각 자리마다 뒤집기 체크
            }
            sum += min(cnt, n - cnt); // 앞과 뒤중 작은 수 선택(간접적인 뒤집기)
        }
        ret = min(ret, sum); // 뒷면 동전 최소화한 값
        return;
    }
    go(here + 1); // 안 뒤집기
    a[here] = ~a[here]; // ~연산 뒤집기(비트체크만 하면 되기 때문에 -는 괜찮)
    go(here + 1); // 뒤집은 후 호출
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 1; i <= n; i++){
        cin >> s;
        for(int j = 0; j < n; j++){
            if(s[j] == 'T') a[i] += (1 << j);
        }
    }
    go(1);
    cout << ret << '\n';
}
/*
1. 각 행을 2진수로 바꿔서 배열 a[]에 저장
2. 재귀로 탐색하면서 확인
*/