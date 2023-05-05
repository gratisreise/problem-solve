#include <bits/stdc++.h>
using namespace std;
string s;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    getline(cin, s);
    for(int i = 0 ; i < s.size(); i++){
        if(s[i] >= 65 && s[i] < 97){
            if(s[i] + 13 > 90) s[i] = s[i] - 13;
            else s[i] = s[i] + 13;
        }else if(s[i] >= 97 && s[i] <= 122){
            if(s[i] + 13 > 122) s[i] = s[i] -13;
            else s[i] = s[i] + 13;
        }
        cout << s[i];
    }
    
    return 0;
}

#include<bits/stdc++.h>
using namespace std;
string s;
int main(){
    ios::sync_withs_stdio(0);cint.tie(0);cout.tie(0);
    getline(cin, s);
    for(char a : s){
        if(a >= 65 && s < 97){
            if(a + 13 > 90) a = a - 13;
            else a = a + 13 
        }else if(a >= 97 && a <= 122){
            if(a + 13 > 122) a = a - 13;
            else a = a + 13;
        }
        cout << a;
    }
    
    return 0;
}