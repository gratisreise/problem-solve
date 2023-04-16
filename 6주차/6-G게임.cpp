#include<bits/stdc++.h>
using namespace std;
typedef long long ll; // long long 자료형을 ll로 선언
ll a, b, mid, ret = -1; // 입력값 a, b와 이분탐색을 위한 mid, 최종 결과값 ret 선언 및 초기화
int main(){
    cin >> a >> b; // a와 b를 입력받음
    ll z = b * 100 / a; // 승률을 계산하여 z에 저장
    ll lo = 1, hi = 1e9; // 이분탐색을 위한 lo, hi를 초기화
    while(lo <= hi){ // 이분탐색 시작
        mid = (lo + hi) / 2; // mid를 갱신
        if((b + mid) * 100 / (a + mid) > z){ // 승률이 증가하는 경우
            ret = mid; // ret에 mid를 저장
            hi = mid - 1; // hi 갱신
        }else lo = mid + 1; // 승률이 감소하는 경우, lo 갱신
    }
    cout << ret << '\n'; // 결과 출력
    return 0;
}
