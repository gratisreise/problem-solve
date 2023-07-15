#include <bits/stdc++.h>
using namespace std;
int n;
int main(){
    while(scanf("%d", &n) != EOF){ // tc를 받고 입력을 받는것이 아니라 주어진 숫자 만큼 입력받는 것
        int cnt = 1, ret = 1;// cnt는 1로만 이루어진 배수 ret은 1의 자리니깐 1부터 시작
        while(true){ //루프생성-> cnt를 하자리씩 늘리기 위해 루프로 생성
            if(cnt % n == 0){ // cnt가 1로만 이루어진 n의 배수를 찾는다.
                printf("%d\n", ret); //자릿수 ret을 출력
                break;
            }else{
                cnt = (cnt * 10) + 1; // 1로만 이루어진 배수를 계속
                cnt %= n; // 모듈연산 자릿수가 커져 범위를 벗어날 수 있기 때문에 
                ret++;
            }
        }
    }
    return 0;
}
/*
((cnt * 10 + 1) * 10 + 1) % n 
((cnt * 10 + 1) % n * 10 + 1) %  n
>>
((cnt * 10 + 1) % n * 10 % n + 1 % n) % n
(a * b + c) % n = (a % n * b + c) % n
a % n = (a % n) % n
(0 ~ n - 1) % n
(0 ~ n - 1)
범위 내에 값을 다시 연산해도 같은 범위의 값을 가진다.
(a % n * b) % n = (a * b) % n
*/
void f(int n){
    for(int i = 1; i <= 100; i++){
        for(int j = 1; j <= 100; j++){
            for(int k = 1; k <= 100; k++){
                int ret = (i * j + k) % n;
                int ret2 = (i % n * j + k) % n;
                if(ret != ret2){
                    cout << i << " : " << j << " : " << k << '\n';
                }
            }
        }
    }
}