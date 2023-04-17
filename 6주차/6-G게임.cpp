#include<bits/stdc++.h>
using namespace std;   
typedef long long ll;  
ll x, y, mid, ret = -1; 
int main(){
	cin >> x >> y; 
	ll z = y * 100 / x;  // 100을 먼저 곱한 이유는 나눴으 때 0방지 -> 계산 순서 이용 
	ll lo = 1, hi = 1e9; // x의 제한범위가 1부터 10억이니깐
	while(lo <= hi){// 얼마를 더해야 변하는지 확인하기 위해 하는 이분탐색
		mid = (lo + hi) / 2; // mid도 갱신을 시켜야 함
		if((y + mid) * 100 / (x + mid) > z){ // 승률이 증가하는 경우
			ret = mid; 
			hi = mid - 1; // mid보다 작은범위에 있으니깐 -1
		}else lo = mid + 1; // mid보다 큰 범위에 있으니깐 +1;
	}  
	cout << ret << "\n"; 
	return 0;
}