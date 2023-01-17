#include <bits/stdc++.h>
using namespace std;
int a,b,c;
int main(){
    cin>>a>>b;
    cin>>c;
    a+=c/60;
    b+=c%60;

    if(b>59)
        a++,b-=60;
        if(a>23)
            a-=24;
    else
        if(a>23)
            a-=24;
    
    cout<<a<<" "<<b<<"\n";   
}