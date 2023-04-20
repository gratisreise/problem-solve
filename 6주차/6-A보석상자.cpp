#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

// 보석 개수, 가게 수, 각 가게별 보석 개수 저장 배열, 최솟값 초기화
ll n, m, a[300004], ret = 1e18;

// mid 값을 기준으로 조건을 만족하는지 검사하는 함수
bool check(ll mid){
    ll num = 0;
    // 모든 가게에서 mid 값으로 나눈 몫과 나머지를 이용해 필요한 상자 개수 계산
    for(int i = 0; i < m; i++){
        num += a[i] / mid; // mid 값으로 나눈 몫
        if(a[i] % mid) num++; // mid 값으로 나눈 나머지가 있는 경우 1 추가
    }
    //보석없는 학생 있어도 되니깐
    return n >= num;
}

int main(){
    // 입력
    cin >> n >> m;  
    for(int i = 0; i < m; i++) cin >> a[i];
    
    // 이분탐색을 위한 lo, hi 값 설정
    ll lo = 1, hi = 0;
    for(int i = 0; i < m; i++) hi = max(hi, a[i]); // 가장 많은 보석을 보유한 가게의 보석 개수를 hi 값으로 설정
    
    // 이분탐색
    while(lo <= hi){
        mid = (lo + hi) / 2; // 중간값 설정
        if(check(mid)){ // mid 값을 기준으로 조건을 만족하는 경우
            ret = min(ret, mid); // 최솟값 갱신
            hi = mid - 1; // 오른쪽 범위를 중간값 mid - 1로 이동
        }else{ // mid 값을 기준으로 조건을 만족하지 않는 경우
            lo = mid + 1; // 왼쪽 범위를 중간값 mid + 1로 이동
        }
    }
    // 결과 출력
    cout << ret << '\n';
    return 0;
}
