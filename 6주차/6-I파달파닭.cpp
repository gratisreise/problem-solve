#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll s, c, a[1000004], ret, sum, ret_cnt;

bool check(ll mid){
    ll cnt = 0;
    for(int i = 0; i < s; i++) cnt += a[i] / mid; // 한 마리 닭에 대해서 mid cm로 나누어 얻을 수 있는 파 조각 수를 구해서 카운트
    return cnt >= c; // 파를 c개 이상 만들 수 있는지 여부를 리턴
}

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> s >> c;
    for(int i = 0; i < s; i++) cin >> a[i], sum += a[i]; // 각 닭의 파닭 길이를 입력 받고, 전체 파닭 길이의 합도 구함
    ll lo = 1, hi = 1e9;
    while(lo <= hi){
        ll mid = (lo + hi) / (1LL * 2); // 이분탐색을 위한 mid
        if(check(mid)){
            lo = mid + 1; // 파를 c개 이상 만들 수 있으므로 mid+1에서 계속 탐색
            ret = mid; // 최적의 파닭 길이를 저장
        }else hi = mid - 1; // 파를 c개 만들 수 없으므로 mid-1에서 계속 탐색
    }
    cout << sum - ret * c << '\n'; // 최적의 파닭 길이로 나눈 후에는 총 파닭 길이에서 그 결과를 곱한 값을 빼서 결과 출력
    return 0;
}
