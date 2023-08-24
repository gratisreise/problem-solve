#include <bits/stdc++.h>
using namespace std;
//배열사용+향상입출력
int main(){
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    int a[9];
    for(int i = 0;i<9;i++){//배열입력
        cin>>a[i];
    }

    int b = -1;
    int c;
    for(int i =0 ;i<9; i++){ //순회하면서 비교
        if(a[i]>b){
            b = a[i];
            c = i+1; //몇 번째 수인지는 1부터 시작이라 +1
        }
    }
    cout<<b<<"\n";
    cout<<c<<"\n";
}
//배열미사용+향상입출력
int main(){
    ios_base::sync_with_stdio(false);cin.tie(NULL);
    int a = -1;
    int b,c;
    for(int i =0; i<9; i++){ //숫자 입력 받음
        cin>>c;
        if(c>a){
            a = c; //순회하면서 큰 수 a에 대입
            b = i+1; // 순회하면서 순서 b에 대입
        }
    }
    cout<<a<<"\n";
    cout<<b<<"\n";
}

#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);
    int n,maxi;
    int max=-1;
    for(int i=0;i<9;i++){
        cin>>n;
        if(n>max){ //입력받는 수를 이용하여 max변수와 비교한다.
            max=n;
            maxi=i+1;
        }
    }
    cout<<max<<"\n";
    cout<<maxi<<"\n";

    return 0;
}
//1.누가 최대인가? -> 최대 변수 설정해주고 그걸 토대로 순회하면서 비교
//2.최대의 순서는 몇번째인가? -> 비교하면서 나온 i값으로 구한다.