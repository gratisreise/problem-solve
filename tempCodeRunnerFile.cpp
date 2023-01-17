#include <bits/stdc++.h>
using namespace std;
int main(){
 int x,t,a,b;
 cin>>x;
 cin>>t;
 for(int i = 0; i < t; i++){
    cin>>a>>b;
    x-=a*b;
 }
 if (x==0) cout << "Yes";
 else cout << "No";
}

//수상한 가격!!! 띠로리!!