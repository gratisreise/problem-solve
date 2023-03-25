#include<bits/stdc++.h>
using namespace std;
int m, n, j, temp, l, r, ret;
int main(){
    cin >> n >> m >> j;
    l = 1;
    while(j--){
        r = l + m - 1; // l을 기준으로 끝점 설정
        cin >> temp; 
        if(l <= temp && temp <= r) continue;
        else{
            if(temp < l){
                ret += (l - temp);
                l = temp;
            }else{
                ret += (temp - r);
                l += (temp - r);
            }
        }
    }
    cout << ret << '\n';
    return 0;
}
/*
1. 그림그리기
2. 좌우 끝점설정 아이디어
3. 변수 하나를 기준으로 다른 변수까지 같이 통제
*/