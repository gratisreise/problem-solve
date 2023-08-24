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
                ret += (l - temp); // ret을 나중에 하면 l r
                l = temp; //이거 먼저 올려서 프로그램 돌리면 ret값에 더해지는 값이 달라진다.
            }else{
                ret += (temp - r);
                l += (temp - r);
            }
        }
    }
    cout << ret << '\n';
    return 0;
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> m >> j;
    l = 1; 
    while(j--){
        r = l + m - 1;
        cin >> temp;
        if(temp < l){
            ret += (l - temp);
            l = temp; 
            // cout << ret << '\n';
        }else if(temp > r){
            ret += (temp - r);
            l += (temp - r);
        }
    }
    cout << ret << '\n';
}
/*
1. 그림그리기
2. 좌우 끝점설정 아이디어
3. 변수 하나를 기준으로 다른 변수까지 같이 통제

*/