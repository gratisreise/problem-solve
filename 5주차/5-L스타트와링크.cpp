#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int s[24][24], ret = INF, n; 
// a와 b가 주어졌을 때, 두 팀의 능력치 차이를 계산하는 함수
int go(vector<int> &a, vector<int> &b){
	pair<int, int> ret;  
	for(int i = 0; i < n / 2; i++){
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
    for (int i = 0; i < (1 << n); i++) {
		if(__builtin_popcount(i) != n / 2) continue; // 이진수 i에 1이 몇개인지 세어서, n/2와 다르면 continue
        vector<int> start, link; // 크기가 작으니깐 지역선언 가능
		for(int j = 0; j < n; j++){
			if(i & (1 << j))start.push_back(j); // i의 j번째 비트가 1이면 start 팀에 포함
			else link.push_back(j); // i의 j번째 비트가 0이면 link 팀에 포함
		}
		ret = min(ret, go(start, link)); // 두 팀의 능력치 차이의 최소값 구하기
    }
    cout << ret << '\n';
}
/*
배열 입력 -> sart와 link 팀 생성 -> go함수로 계산
*/