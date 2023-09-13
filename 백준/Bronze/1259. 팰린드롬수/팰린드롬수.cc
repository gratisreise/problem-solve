#include<bits/stdc++.h>
using namespace std;
string s, temp;
int main(){
    while(true){
        cin >> s;
        if(s == "0") exit(0);
        temp = s;
        reverse(s.begin(), s.end());
        if(temp == s) cout << "yes\n";
        else cout << "no\n";
    }
}