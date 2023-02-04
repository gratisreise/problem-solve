#include <bits/stdc++.h>
using namespace std;
int sum,a[1004]={0,};
int han(int n){//한수 찾기
    if(1<=n){//두자리까지는 어차피 한수
        sum = n;
    }
    if(100<=n){//세자리수부터 조건설정

        if(n/100-(n/10)%10 == (n/10)%10-n%10){ //각자리수 등차
            sum = n;
        }
        else sum = 0;//초기화 시점을 이때 안하면 다 한수로 설정됨
    }
    return sum;
}
int main(){
    int n,cnt=0;
    cin>>n;
    for(int i=1;i<=n;i++){
        a[han(i)]++;//0으로 초기화된 배열에 ++해주기
    }
    for(int i=1;i<=n;i++){
        if(a[i]!=0){
            cnt++;
        }
    }
    cout<<cnt<<'\n';
}
/*
1.한수 구하는 함수 설정
2.배열 한수 인덱스 ++방식으로 문제접근 
3.x가 1000보다 작거나 같다.
4.1보다 크거나 같고 x보다 작거나 같은 한수의 개수를 출력.
*/