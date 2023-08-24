#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int a,b;
    while(a!=0 || b!=0){ 
        cin>>a>>b;
        if(a!=0 || b!=0) cout<<a+b<<"\n"; //
    }
    return 0;
}

#include <bits/stdc++.h>
using namespace std;
int main(){
    int a,b;
    
    while(true){ //break반드시 필요 없으면 계속 돌아감
        cin>>a>>b;
        if(a==0 & b==0){// a와 b가 모두 0이라면 while문 종료
            break;
        }
        cout<< a+b<<"\n";
    }
    return 0;
}