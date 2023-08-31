#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;cin>>n;int s = 0;//초기화 안시키고 반복문 집어 넣으면 숫자가 정해지지 않은 상태에서 주소로설정
    for(int i = 0; i<=n;i++){
        s+=i;
    }
    cout<<s<<"\n";
}