#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n;
    cin>>n;
    for(int i=1;i<=n;i++){ //입력받은 수 반복
        for(int j=1; j<=i; j++){ //찍는 별의 수 반복
            cout<<"*";
        }
        cout<<"\n"; //반복 완료된 후 개행 받아주기
    }
}