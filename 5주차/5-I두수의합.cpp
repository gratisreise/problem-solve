#include<bits/stdc++.h>
using namespace std; 
int n, ret, x; 
int main(){
    cin >> n; 
    vector<int> a(n); 
    for(int i = 0; i < n; i++) cin >> a[i]; 
    cin >> x; 
    sort(a.begin(), a.end()); // 숫자가 너저분하게 주어짐
    int l =  0, r = n - 1;  // 투 포인터를 위한 변수 설정 왼, 오
    while(l < r){ // 당연한게 당연할 때
        if(a[l] + a[r] == x)r--, ret++; // 합이 맞는 경우 아무거나 노상관
        else if(a[l] + a[r] > x)r--; // 크니깐 작게
        else if(a[l] + a[r] < x)l++; // 작으니깐 크게
    }
    cout << ret << "\n";
    return 0;
}
/*
투포인터 알고리즘 사용
10^5 이 곱해지면 10억 ㅎㅎ...
*/