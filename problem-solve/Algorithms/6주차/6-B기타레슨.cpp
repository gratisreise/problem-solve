#include<bits/stdc++.h>
using namespace std;
int n, m, lo, hi, ret, a[100004], sum, mx;
bool check(int mid){
    if(mx > mid) return false;  // 레슨의 최대 길이가 mid보다 크면 mid로 불가능
    int temp = mid;
    int cnt = 0;
    for(int i = 0; i < n; i++){
        if(mid - a[i] < 0){ // 크기가 음수면 블루레이 증가
            mid = temp; // 다시 충전
            cnt++; // 썻으니깐 추가
        }
        mid -= a[i]; //계속빼주면서 체크
    }
    if(mid != temp) cnt++; // 마지막 mid가 0보다 크면 마지막 블루레이에 포함 안되므로 cnt 증가
    return cnt <= m;
}
int main(){
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        cin >> a[i];
        sum += a[i];
        mx = max(mx, a[i]);
    }
    lo = 0; hi = sum;
    while(lo <= hi){
        int mid = (lo + hi) / 2;
        if(check(mid)){
            hi = mid - 1;
            ret = mid;
        }else lo = mid + 1;
    }
    cout << ret < '\n';
    return 0;
}