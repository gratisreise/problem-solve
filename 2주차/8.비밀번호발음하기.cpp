#include <bits/stdc++.h>
using namespace std;  
string s; 
int lcnt, vcnt; 
bool isVowel(int idx){
	return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u');
}
int main () { 
	while(true){
		cin >> s; 
		if(s == "end")break; // 종료시점을 맞춰줄려고
		lcnt = vcnt = 0; // 자,모3 나오는거 체크할려고
		bool flag = 0;  // 자. 모 3연속이면 트루로 변환
		bool is_include_v = 0; //모음 있는지 확인 할려고
		int prev = -1; //배열의 직전과 비교하기 위한 임시변수
		for(int i = 0; i < s.size(); i++){
			int idx = s[i]; 
			if(isVowel(idx)) lcnt++, vcnt = 0, is_include_v = 1; // 모음 하나 반드시 포함
			else vcnt++, lcnt = 0;
			if(vcnt == 3 || lcnt == 3) flag = 1;  // 모음, 자음이 3개 연속 X
			if(i >= 1 && (prev == idx) && (idx != 'e' && idx != 'o')){ // 같은 글자가 연속 두번 X 하지만 e와 o는 허용
				flag  = 1;
			} 
			prev = idx;
		}  
		if(is_include_v == 0) flag = 1;
		if(flag) cout << "<" << s << ">" << " is not acceptable.\n";
		else cout << "<" << s << ">" << " is acceptable.\n";
	} 
	return 0;
}