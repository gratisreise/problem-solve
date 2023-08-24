#include<bits/stdc++.h> 
using namespace std;  
int n, ret; 
string s; 
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n; 
	for(int i = 0; i < n; i++){
		cin >> s; 
		stack<char> stk; // 매번 새로운 스택이 필요하다.
		for(char a : s){
			if(stk.size() && stk.top() == a)stk.pop(); // 팁 사이즈 먼저 체크하고 top
			else stk.push(a);  
		} 
		if(stk.size() == 0) ret++;
	}
	cout << ret << "\n"; 
}
/*
1.아이디어가 안 떠오를 때는 90도 회전,덧붙이기, 뒤집어보기
2.문제에서 짝짓기,폭발 -> stack 생각해보기

*/