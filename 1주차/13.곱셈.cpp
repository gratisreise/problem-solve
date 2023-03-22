#include<bits/stdc++.h> 
using namespace std;
typedef long long ll;
ll a, b, c;
ll go(ll a, ll b){
    if(b == 1) return a % c;  //기저사례
    ll ret = go(a, b / 2); //
    ret = (ret * ret) % c; //곱하기 후 모듈러 연산
	if(b % 2)ret = (ret * a)% c;//1은 true, 이해 잘 안됨, a를 한번 더 곱한 뒤 모듈러연산
    return ret;
}
int main() {
    ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
    cin >> a >> b >> c;
    cout << go(a, b) << "\n";
    return 0;
}
/*
1. 재귀함수
2. 모듈러 연산  
3. 데이터 타입별 크기제한
4. 재귀함수 로직 짜는방법 진짜 이해가 안되네 -> 많이 보기, 손코딩 많이 해보기
*/