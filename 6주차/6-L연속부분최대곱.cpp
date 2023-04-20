#include<bits/stdc++.h>
using namespace std;
int n;
double a[10001], ret, b;
int main(){
    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    double b = a[0];
    for(int i = 1; i < n; i++){
        if(a[i] > b * a[i]) b = a[i]; // 이전 거와 곱한 거보다 현재가 더 크면 b를 다시 
        else b *= a[i]; // 아니면 계속 곱해주기
        ret = max(b, ret); // 매반복마다 ret에 max를 저장
    }
    printf("%.3lf", ret); // 4째자리에서 반올림 5째자리 더해서 정확한 반올림 해줌
    return 0;
} 

