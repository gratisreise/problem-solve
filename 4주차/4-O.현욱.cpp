#include<bits/stdc++.h>
using namespace std;
int n, d[200001], ret, cnt; 
string s;
stack<int> stk;
int main() {
	ios_base::sync_with_stdio(0);cin.tie(0); 
	cin >> n >> s;   
	for (int i = 0; i < n; i++) {
		if (s[i] == '(') stk.push(i);  
		else if(stk.size()){ 
				d[i] = d[stk.top()] = 1;
				stk.pop(); 
		}
	} 
	for (int i = 0; i < n; i++){
		if (d[i]) {
			cnt++;
            ret = max(ret, cnt);   
		}else cnt = 0;  
	}
	cout << ret << "\n"; 
}

<stack>
#include<bits/stdc++.h>
using namespace std;
int n, cnt, ret;
string str;
stack<int> s;
int main(){
    cin >> n;
    cin >> str;
    s.push(-1); //숫자 맞춰주기
    for(int i = 0; i < n; i++){
        if(str[i] == '(') s.push(i);
        if(str[i] == ')'){
            s.pop();
            if(!s.empty()){
                ret = max(ret, i - s.top());
            }else{
                s.push(i); // 분기점 사용 max 맞춰주기
            }
        }
    }
    cout << ret << '\n';
    return 0;
}