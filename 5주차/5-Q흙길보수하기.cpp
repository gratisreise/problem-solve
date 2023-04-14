#include<bits/stdc++.h>
using namespace std;   
int n, l, idx, ret, b; // b: 보수지점
int main(){
	ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
	cin >> n >> l; 
	vector<pair<int,int>> a(n); // 시작과 끝 저장
	for(int i = 0; i < n; i++) cin >> a[i].first >> a[i].second; 
	sort(a.begin(), a.end()); // 시작점 기준 오름차순 정렬
	for(int i = 0; i < n; i++){ // 
		if(a[i].second <= idx) continue; // 끝점이 널빤지보다 작은지점이면 컨티뉴
 		if(idx < a[i].first){ // 이전 보수 지점의 끝이 현재 시작점보다 작을 때
			b = (a[i].second - a[i].first) / l + ((a[i].second - a[i].first) % l ? 1 : 0); 
			idx = a[i].first + b * l; 
		}else{ // 이전 보수 지점이 현재시작점보다 클 때
			b = (a[i].second - idx) / l + ((a[i].second - idx) % l ? 1 : 0); 
			idx = idx + b * l; 
		}  
		ret += b; // 보수지점의 총합 
	} 
	cout << ret << "\n"; 
	return 0;
} 
/*
구간마다 보수니깐 삐져나오는 공간이 있어 굳이 보수 안해도 될 수도 있다.
*/