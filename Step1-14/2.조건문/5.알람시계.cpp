#include <bits/stdc++.h>
using namespace std;
int main(){
    int h,m;
    cin>>h>>m;
    if(m>=45) m-=45;
    else {
    h--;m+=15;
        if(h<0) h+=24;
    }
    cout<<h<<" "<<m<<"\n";
}