#include <bits/stdc++.h>
using namespace std;
int T, N, x;
string P, order;
int main(){ 
	cin >> T;  
    for(int t = 0; t < T; t++){ 
        deque<int> D;
        cin >> P >> N >> order;
        x = 0;
        for(char c : order){
        	if(c == '[' || c == ']') continue;
            if(c >= '0' && c <= '9') x = x * 10 + c - '0'; // 숫자가 나오면 현재 수*10 한 뒤 더함         
            else{ // 아닐 경우 현재 수를 덱에 넣음
                if(x > 0) D.push_back(x);
                x = 0; 
            }
		} 
		if(x > 0) D.push_back(x); // 초기에는 에러 없음, 뒤집히지 않은 상태
        bool error = false, rev = false;
 		for(char a : P){
 			if(a == 'R') rev = !rev; 
 			else{ // 비어있는데 제거하려 하면 에러
                if(D.empty()){
                    error = true;
                    break;
                }
                if(rev) D.pop_back();
                else D.pop_front(); 
			}
		
        
        if(error) cout << "error" << '\n'; // 에러가 발생한 경우
        
        else{ // 아닐 경우 덱의 원소를 하나하나 출력
        	cout << "[";  // 덱이 뒤집힌 상태면 진짜로 뒤집어 준다.
            if(rev) reverse(D.begin(), D.end());
            for(int i = 0; i < D.size(); i++){
        		cout << D[i];  
                if(i < D.size()-1) cout << ",";
            }
        	cout << "]\n";  
        }
    }
} 