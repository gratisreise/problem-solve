#include<bits/stdc++.h>
using namespace std;
int a[10004];
int d(int n){
    int ret = n;
    while(n > 0){
        ret += n % 10;
        n /= 10;
    }
    return ret; 
}
int main(){
    for(int i = 1; i <= 10000; i++) a[d(i)]++;
    for(int i = 1; i <= 10000; i++) if(a[i] == 0) cout << i << '\n';
}
/*
각 자리의 자릿수는 
10의 모듈려 연산관 나누기 연산으로 구할 수 있다.

*/