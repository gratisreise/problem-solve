#include <bits/stdc++.h>
using namespace std;
int n;
int a[1000004];
// 정렬함수 이용
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin>>n;
    for(int i =0; i<n;i++){
        cin>>a[i];
    }
    sort(a, a + n); //
    cout<<a[0]<<" "<< a[n-1]<<"\n";

    return 0;
}
//index이용
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n,a;
    int max=-2000000; //최대값 넣을 변수선언
    int min=2000000; //최솟값 넣을 변수선언
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>a;
        if(a>max){
            max=a;
        }
        if(a<min){ 
            min=a;
        }
    }
    cout<<min<<' '<<max<<'\n';

    return 0;
}