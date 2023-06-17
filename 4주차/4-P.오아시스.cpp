#include <bits/stdc++.h>
using namespace std;
typedef long long ll;  
ll n, ret, temp;
stack<pair<ll, ll>> s; //<값, 해당 ㄱ밧이 나온 횟수>를 저장하는 스택
int main() {
	cin >> n;  
	for(int i = 0; i < n; i++){
		cin >> temp;
		int cnt = 1; // 해당 값이 나온 횟수를 카운트하는 변수 초기화
        //현재 입력된 값보다 적은 값을 스택에서 제거하면서 누적 계수 계싼
		while(s.size() && s.top().first <= temp){
			ret += s.top().second; 
			if(s.top().first == temp){
                // 만약 현재 입력된 값과 같은 값이 이미 스택에 있다면
                // 해당 ㄱ밧이 몇 번째 나왔는지 카운트 해주고 스택에 push
				cnt = s.top().second + 1;  
			}else{  // 그렇지 않으면 다시 첫 번째로 나왔으므로 카운트 변수를 1로 초기화하고 push
                
				cnt = 1; 
			}
			s.pop(); // 스택에서 제거
		}
		if(s.size()) ret++; // 스택에 값이 남아있다면 해당 ㄱ밧과 짝을 이루지 못한 것이므로 +1
		s.push({temp, cnt}); // 현재 입력된 값과 해당 값이 몇 번째로 나왔는지 스택에 push
	}
	cout << ret << '\n';
    return 0;
} 