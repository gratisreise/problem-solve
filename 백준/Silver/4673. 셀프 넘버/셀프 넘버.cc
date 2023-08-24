#include<bits/stdc++.h>
using namespace std;
int a[10004];
int d(int n){
    int ret = n;
    while(n > 0){
        ret += n % 10;
        n /= 10;
    }
    return ret; 
}
int main(){
    for(int i = 1; i <= 10000; i++) a[d(i)]++;
    for(int i = 1; i <= 10000; i++) if(a[i] == 0) cout << i << '\n';
}