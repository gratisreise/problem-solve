#include<bits/stdc++.h>
using namespace std;
int x, n, t;
int main(){
    cin >> x;
    while(x > n * (n + 1) / 2) n++;
    t = n * (n + 1) / 2  - x;
    if(n + 1 & 1)cout << n - t <<"/"<< 1 + t << '\n';
    else cout << 1 + t <<"/"<< n - t << '\n';
} 
/*
1. n++하면서 n번까지의 등차합이 x보다 처음으로 큰지점에서 break
2. 그 지점에서 x를 뺀게 분모와 분자의 값에 더하고 빼줄 값
3. 분모분자 합이 짝수인 것과 홀수인 것을 분리해서 출력
*/

//
#include<bits/stdc++.h>
using namespace std;
int x, n = 1;
int main(){
    cin >> x;
    while(x > n){
         x -= n;  // 등차합 빼는 방법 
        n++; // n++을 이용해 나중에 비교
    }
    if(n & 1) cout << n + 1 - x << "/" << x << '\n';
    else cout << x << '/' << n + 1 - x << '\n';
}
/*
1.
*/