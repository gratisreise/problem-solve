#include<bits/stdc++.h>
using namespace std; 
const int n = 18; //
bool isP[20]; //
double 
 a, // a팀 확률
 b, // b팀 확률
dp[20][20][20];  // 어떤 상태를 저장하지??
//dp 탐색
double go(int idx, int x, int y){
    // 둘중 하나라도 만족하면 1
    if(idx == n) return isP[x] || isP[y] ? 1.0 : 0.0; 
    // 메모이제이션
    double &ret = dp[idx][x][y];
    // 리턴 조건 -0.5
    if(ret > -0.5) return ret; 
    // 확률을 더해간다는 건 알겠는데.. 흠...
    ret = 0.0; 
    ret += go(idx + 1, x + 1, y) * a * (1 - b); 
    ret += go(idx + 1, x + 1, y + 1) * a * b; 
    ret += go(idx + 1, x, y + 1) * (1 - a) * b; 
    ret += go(idx + 1, x, y) * (1 - a)* (1 - b); 
    return ret;  
}
// 골 넣는 로직, 소수체크
void era(){
    fill(isP, isP + 20, 1); // 왜 초기화?
    isP[0] = 0; isP[1] = 0; // 왜 선언?
    for(int i = 2; i <= 20; i++){ // 에라토스랑 비슷..
        for(int j = i + i; j <= 20; j += i){
            isP[j] = 0; 
        }
    }
}
int main(){ 
    // 확률 받기
    scanf("%lf %lf", &a, &b);
    a /= 100; b /= 100;
    era();
    // dp 배열 초기화
    memset(dp, -1, sizeof(dp));
    printf("%.6lf", go(0, 0, 0));
}