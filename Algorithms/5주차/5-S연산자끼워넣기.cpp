#include<bits/stdc++.h>
using namespace std;  
int n; // 수열의 길이
int a[12], b[4]; // a: 수열을 저장하는 배열, b: 주어지는 4가지 연산자의 갯수 저장
int p, minu, mult, divi; // 연산재의 갯수를 입력받아 저장하는 변수
int ret = -1000000001; // 최댓값
int ret2 = 1000000001; // 최솟값
void go(int index, int cur, int plus, int minus, int mul, int div){ 
    // cur : 현재까지의 계산 결과,
    //printf("%d\n", index);
    if(index == n - 1){
        ret = max(cur, ret); 
        ret2 = min(ret2, cur);
        return; 
    }
    if(plus) go(index + 1, cur  + a[index + 1], plus - 1, minus, mul, div);
    if(minus) go(index + 1, cur - a[index + 1], plus, minus - 1, mul, div);
    if(mul) go(index + 1, cur * a[index + 1], plus, minus, mul - 1, div);
    if(div) go(index + 1, cur / a[index + 1], plus, minus, mul, div - 1);
    return;
}
int main(){
    scanf("%d", &n);
    for(int i = 0; i < n; i++){ 
        scanf("%d", &a[i]); 
    }    
    scanf("%d %d %d %d", &p, &minu, &mult, &divi);
    go(0, a[0], p, minu, mult, divi);
    printf("%d\n%d\n", ret,ret2);
    return 0; 
}