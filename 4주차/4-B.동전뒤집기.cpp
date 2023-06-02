#include<bits/stdc++.h>
using namespace std;
int n, ret = 1e9, a[44]; string s;
// 동전 뒤집기 + 재뒤집 표현
void go(int here){
    if(here == n + 1){
        int sum = 0;
        for(int i = 1; i <= (1 << (n - 1)); i *= 2){ // 행
            int cnt = 0; // 뒷면의 갯수 합 저장
            for(int j = 0; j < n; j++){ // 열
                if(a[j] & i) cnt++; // 뒷면 동전체크
            }
            sum += min(cnt, n - cnt); // 앞과 뒤중 작은 수 선택
        }
        ret = min(ret, sum); // 뒷면 동전 최소화한 값
        return;
    }
    go(here + 1); // 재귀 호출
    a[here] = ~a[here]; // 뒤집기
    go(here + 1); // 뒤집은 걸로 들어가기
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> s;
        for(int j = 0; j < n; j++){
            if(s[j] == 'T') a[i] += (1 << j);
        }
    }
    go(0);
    cout << ret << '\n';
}
/*
1. 각 행을 2진수로 바꿔서 배열 a[]에 저장
2. 재귀로 탐색하면서 확인
*/