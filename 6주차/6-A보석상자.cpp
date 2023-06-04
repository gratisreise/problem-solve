#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

// 보석 개수, 가게 수,
ll n, m, a[300004], ret = 1e18;

// 수가 커져야할때랑 작아져야할 때 나눔
bool check(ll mid){ //mid가 나눠지는 보석의 
    ll num = 0; // 나눠지는 보석 수 체크
    for(int i = 0; i < m; i++){ // 나눠가지는 학생 수를 체크할려고
        num += a[i] / mid;
        if(a[i] % mid) num++; // 같은 색상만 가능하니깐 덜 받아도 ++
    }
    return n >= num; // 학생이 보석 없어도 된다.
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < m; i++) cin >> a[i];
    
    //이분탐색 lo, hi 값 설정
    ll lo = 1, hi = 0;
    for(int i =0; i < m; i++) hi = max(hi, a[i]);

    // 이분탐색
    while(lo <= hi){ // 최소의 질투심을 향해가는 여정
        ll mid = (lo + hi) / 2; // 이분탐색 중간값 설정
        if(check(mid)){ // 왜 조건을 만족하면 -1이지 -> 왜냐하면 학생수가 num보다 많다는 것은 기준은 맞지만 질투심이 크다
            ret = min(ret, mid); // 이거 대소비교 왜하지?? 그냥 ret = mid 안되나??
            hi = mid - 1; 
        }else{ // 왜 아니면 + 1이지?? -> 왜냐하면 num이 학생수보다 많다는 것은 질투심이 기준에 안맞게작다
            lo = mid + 1;
        }
    }

    cout << ret << '\n';
    return 0;
}
/*
여기서 질투심은 나눠가질 수 있는 보석의 최대값
입력(보석 수 배열)
    |
질투심 이분탐색 -> 조건: 학생 수 >= 보석수 / 질투심
    |
출력!!
*/