#include<bits/stdc++.h>
using namespace std;
string s;
int a[26];
int main(){
    cin >> s;
    for(char c : s) a[c - 'a']++;
    for(int i : a) cout << i << ' ';
}