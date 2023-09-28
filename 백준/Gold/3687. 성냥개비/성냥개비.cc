#include<bits/stdc++.h>
using namespace std;  
//1. 그리디와 dp(바텀업) 
int a[10] = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6},t, n;
string dp[104], MAX_STR = "111111111111111111111111111111111111111111111111119";
string get_min_str(string a, string b){
	if(a.size() == b.size()) return (a < b ? a : b); 
	if(a.size() < b.size()) return a; 
	return b;  
}
// 그리디 
string findMax(int here){  
	string ret = "";
	if(here & 1){ret += '7'; here -= 3; }
	while(here){
		ret += '1';
		here -= 2; 
	}
	return ret;   
} 
int main(){
	ios::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
	cin >> t;
	fill(dp, dp + 104, MAX_STR);
	dp[0] = "";
	for(int i = 2; i < 104; i++){
		for(int j = 0; j <= 9; j++){
			if(i - a[j] < 0) continue;
			if(j == 0 && dp[i - a[j]] == "") continue;
			dp[i] = get_min_str(dp[i], dp[i - a[j]] + to_string(j));
		}
	}
	while(t--){   
		cin >> n;  
		cout << dp[n] << " " << findMax(n) << "\n";
	}
}