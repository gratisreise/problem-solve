#include<bits/stdc++.h>
using namespace std;
int m, n, j, temp, l, r, ret;
int main(){
    cin >> n >> m >> j;
    l = 1;
    while(j--){
        r = l + m - 1;
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