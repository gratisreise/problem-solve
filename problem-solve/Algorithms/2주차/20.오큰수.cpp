#include <bits/stdc++.h>
using namespace std;
int n, a[1000004], ret[1000004];
stack<int> s;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> n;
    memset(ret, -1, sizeof(ret)); // 오큰 수 없을 때 -1이 나와야 하므로
    for(int i = 0; i < n; i++){ // 배열에 숫자를 넣어주고, 오큰 수를 저장하느 로직을 구현!
        cin >> a[i]; // 숫자를 저장
        while(s.size() && a[s.top()] < a[i]){ //오큰수를 ret 배열에 저장하는 로직
            ret[s.top()] = a[i]; s.pop(); //오큰수를 담아주고 저장된 수 팝!
        }
        s.push(i);
    }
    for(int i = 0; i < n; i++) cout << ret[i] << " "; // 각 번호의 오큰 수 출력

    return 0;
}
/*
1.입력
    (1) a배열에 넝기
    (2) stack에 넣기
2.순회
    (1) 조건체크하기
    (2) b배열담기
3.출력
    (1) 순회하면서 출력
*/