#include<bits/stdc++.h>
using namespace std;
int x, sta, ret, cnt;
vector<int> v;
int main(){
    cin >> x;
    while(x > 1){ // 진법 변환 
        v.push_back(x % 2);
        x /= 2;
    }
    if(x == 1) v.push_back(1);
    for(int i : v) if(i == 1) cnt++;
    cout << cnt << '\n';
}

// 큰돌
#include <bits/stdc++.h>
using namespace std;
int n, ret = 1; //64보다 작거나 같으니깐 최소가 1
int main(){ 
	cin >> n; 
	while(n != 1){ // n이 1이면 
        if(n & 1) ret++;  //n이 홀수일 때 1이 생성되므로 ++
        n /= 2; // 나누기 2해서 넣어주기
	}
	cout << ret << '\n'; // 
    return 0;
}