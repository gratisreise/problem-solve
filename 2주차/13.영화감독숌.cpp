#include<bits/stdc++.h>
using namespace std;
int main(){
    cin >> n;
    int i = 666;
    for(;;i++){
        if(to_string(i).find("666") != string::npos) n--;
        if(n == 0) break;
    }
    cout << i << '\n';
}
/*
1. n입력 받기
2. for i++로 무한루프로 i++하면서 if로 string으로 변환한 i에서 666 발견될 시 n--
3. n == 0이 되면 cout << i << '\n';
*/