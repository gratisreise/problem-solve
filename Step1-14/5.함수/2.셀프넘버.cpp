#include <bits/stdc++.h>
using namespace std;
int n,sum;
int a[20001]={0,};
int d(int n){
    sum=n+(n/1000)+((n%1000)/100)+(n%100/10)+(n%10);
    return sum;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n=1;
    while(n<=10000){
        a[d(n)]++; n++;
    }
    for(int i =1; i<=10000;i++){
        if(a[i]==0){
            cout<<i<<'\n';
        }
    }
    
    return 0;
}
//1.양의 정수n이 주어졌을 때 이 수를 시작해서 무한수열 생성 가능 d(n)=n+n/10+n%10
//2.10000보다 작거나 같은 셀프 넘버를 출력해야한다.-> 즉 d(n)으로 생성되는 수를 없애야함
//3.d(n)에 넣었을 때 만들어지는게 없으면 그 숫자가 바로 생성자!!