#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
int t,n;
string a,b;
int main(){
    cin >> t;
    while(t--){ //숫자 t만큼 반복
        cin >> n;
        map<string,int> mp; //맵은 반복할 때마다 선언
        for(int i = 0; i < n; i++){ 
            cin >> a >> b;
            mp[b]++;//종류의 숫자 만큼 value에 더해준다.
        }
        ll ret = 1; //곱하기 연산자 대기
        for(auto c : mp){ //맵에 있는 요소순회 키는 first 값은 value
            ret *= ((ll)c.second + 1);
        }
        ret--;
        cout << ret <<'\n';
    }
    return 0;
}
/*
1. 경우의 수는 수가 커질 수 있으니깐 ll을 쓰는게 좋다
2. while(t--) t숫자만큼 반복
3. 안입는 경우를 추가해서 곱한 후 아예 안 입은 경우를 빼준다.
4. auto == map<string, int>::iterator
*/