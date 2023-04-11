#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll s, e, n, ret; // s: 현재 부분수열의 시작위치, e: 현재 부분수열의 끝위치
ll cnt[100001], a[100001];
int main(){
    scanf("%lld", &n); 
    for(int i = 0; i < n; i++){ // a 입력받기
        scanf("%lld", a + i); 
    }
    while(e < n){ // 투포인터 사용 
        if(!cnt[a[e]]){ // 해당원소 등장한 적이 없다면
            cnt[a[e]]++; // cnt배열 없데이트 
            e++; //e증가
        }else{ // 등장한 적이 있다면
            ret += (e - s); // 서로다른 부분수열의 갯수 더함
            cnt[a[s]]--; //s위치 원소의 등장횟수 하나 감소시키고 s를장가
            s++;
        }
    }
    ret += (ll)(e - s) * (e - s + 1) / 2; //???
    printf("%lld\n", ret);
    return 0;
}

/*
같은 지점 투포인터
*/