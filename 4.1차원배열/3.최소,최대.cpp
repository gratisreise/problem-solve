#include <bits/stdc++.h>
using namespace std;
int n;
int a[1000004];

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin>>n;
    for(int i =0; i<n;i++){
        cin>>a[i];
    }
    sort(a, a + n); //
    cout<<a[0]<<" "<< a[n-1];

    return 0;
}