#include<bits/stdc++.h>
using namespace std;
int n;
int main(){
    cin >> n;
    for(int i = 1;; i++){
        if(to_string(i).find("666") != string::npos) n--;
        if(!n) {cout << i << '\n'; break;}
    }
}