#include <bits/stdc++.h>
using namespace std;
bool check(int n){ //소수 찾는 논리형 함수 설정
    if(n<=1) return 0;
    if(n==2) return 1;
    if(n%2==0) return 0;
    for(int i=2; i*i<=n;i++){
        if(n%i==0) return 0;
    }
    return 1;
}
int main(){
    int cnt=0;
    int n,a;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>a;
        if(check(a)){
            cnt++;
        }
    }
    cout<<cnt<<'\n';
    
    return 0;
}