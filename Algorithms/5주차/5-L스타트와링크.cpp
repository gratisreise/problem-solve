#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int s[24][24];
int n, ret = INF; 
// a와 b가 주어졌을 때, 두 팀의 능력치 차이를 계산하는 함수
int go(vector<int> &a, vector<int> &b){
	pair<int, int> ret;  
	for(int i = 0; i < n / 2; i++){ // 각 팀이 n/2명씩 있으니깐 
		for(int j = 0; j < n / 2; j++){
			if(i == j)continue;
			ret.first += s[a[i]][a[j]]; // a팀의 능력치 합
			ret.second += s[b[i]][b[j]]; // b팀의 능력치 합
		}
	}
	return abs(ret.first - ret.second); // 두 팀의 능력치 차이 절댓값 반환
}
int main() { 
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> s[i][j];
        }
    } 
    for(int i = 0; i < (1 << n); i++) { //비트마스킹 모든 경우의 수
		// 1의 갯수가 n / 2개 여야한다.
		// 함수역할 비트가 켜져있는지 확인, & 사용해도 됨, 카카오 비트마스킹 자주나옴
		if(__builtin_popcount(i) != n / 2) continue; // 이진수 i에 1이 몇개인지 세어서, n/2와 다르면 continue
		// 비트가 켜져있는게 몇개인가?? 팝카운트
        vector<int> start, link; // 반복마다 팀이 새롭게 초기화 되야 하니깐
		for(int j = 0; j < n; j++){ //팀 배정
			if(i & (1 << j)) start.push_back(j); // i의 j번째 비트가 1이면 start 팀에 포함
			else link.push_back(j); // i의 j번째 비트가 0이면 link 팀에 포함
		}
		ret = min(ret, go(start, link)); // 두 팀의 능력치 차이의 최소값 구하기
    }
    cout << ret << '\n';
}
/*
배열 입력 -> sart와 link 팀 생성 -> go함수로 계산
*/