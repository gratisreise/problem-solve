#include<bits/stdc++.h>
using namespace std;
int n; string s;
int main(){
    cin >> n;
    while(n--){
        cin >> s;
        cout << *s.begin() << *(s.end() - 1) << '\n';
    }
}