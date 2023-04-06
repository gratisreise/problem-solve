#include<bits/stdc++.h>
using namespace std;
const int n = 4;
int main(){
    //idx번째 비트끄기
    int S = 18;
    int idx = 1;
    S &= ~(1 << idx);
    cout << S << '\n'; // 16;

    //idx번째 비트 XOR 연산(0은 1로, 1은 0으로)
    int S = 18;
    int idx = 1;
    S = (1 << idx);
    cout << S << '\n'; // 16

    // 최하위 켜져있는 비트 찾기
    int S = 18;
    int idx = (S & -S);
    cout << idx << '\n';

    // 크기가 n인 집합의 모든 비트 켜기
    int n = 4;
    cout << (1 << n) - 1 << '\n'; // 15

    //idx번째 비트를 켜기
    int S = 18;
    int idx = 0;
    S |= (1 << idx);
    cout << S << '\n'; // 19
    
    //idx번째 비트 켜져있는지 확인하기
    int S = 18;
    int idx = 0;
    if(S & (1 << idx)){
        cout << "해당 idx : " << idx << "가 켜져있습니다.\n";
    }else{
        cout << "해당 idx : " << idx << "가 꺼져있습니다.\n";
    }

    // 비트마스킹을 이용한 매개변수 전달
    string a[n] = {"사과", "딸기", "포도", "배"};  // 문자열 배열 a를 초기화합니다.
    for(int i = 0; i < (1 << n); i++){  // 0부터 2^n-1까지 반복하는 완전탐색을 수행합니다.
        string ret = "";  // 선택된 문자열들을 담을 빈 문자열을 초기화합니다.
        for(int j = 0; j < n; j++){  // 문자열 배열 a의 모든 원소에 대해 반복합니다.
            if(i & (1 << j)){  // i의 j번째 비트가 1이라면, 즉 j번째 문자열이 선택된 경우
                ret += (a[j] + " ");  // 선택된 문자열을 빈 문자열에 추가합니다.
            }
        }
    cout << ret << '\n';  // 선택된 문자열들을 출력합니다.
    }
}
/*
10억 이하 즉2^30이하에서 쓰는게 최선이다.
*/