#include <bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int t,n;
    int count = 0;
    cin >> t;
    n = t;
    do{ //선 실행 후 조건 확인
        n = (n%10)*10 + ((n/10)+(n%10))%10;
        count ++;
    }while(n != t);

    cout<< count<<"\n";
    return 0;
}