#include <bits/stdc++.h>
using namespace std;
bool check(int n){
    if(n<=1) return 0;
    if(n==2) return 1;
    if(n%2==0) return 0;
    for(int i=2;i*i<=n;i++){
        if(n%i == 0) return 0;
    }
    return 1;
}
int main(){
    int m,n;
    int sum = 0,cnt=0;
    int pr[10000]={0,};
    cin>>m>>n;
    for(int i=m; i<=n;i++){
        if(check(i)){
            sum+=i;
            pr[i]=i;
            cnt++;
        }
    }
    sort(pr,pr+10000);
    if(sum==0) cout<<-1<<'\n';
    else {
        cout<<sum<<'\n';
        cout<<pr[10000-cnt]<<'\n';
    }
    return 0;
}
//배열에 넣고 정렬해서 최솟값