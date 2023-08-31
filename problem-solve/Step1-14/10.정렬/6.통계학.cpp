#include <bits/stdc++.h>
using namespace std;
int coordinate[500001];
int cnt[8001];
int N,a,b,c,d;
int sum = 0;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin>> N;
    for(int i=0;i<N;i++){
        cin>>coordinate[i];
        sum+=coordinate[i];
        cnt[coordinate[i]+4000]++;
    }
    sort(coordinate,coordinate + N);

    int flag;
    int max  = 0;
    for(int i = 0;i<8001;i++){
        if(cnt[i]>max){
            max=cnt[i];
            flag=i;
        }
    }
    for(int i=flag+1;i<8001;i++){
        if(cnt[i]==max){
            flag=i;
            break;
        }
    }

    a=round(double(sum)/N);
    b=coordinate[(N-1)/2];
    c=flag-4000;
    d=coordinate[N-1]-coordinate[0];
    cout<<a<<'\n';
    cout<<b<<'\n';
    cout<<c<<'\n';
    cout<<d<<'\n';

    return 0;
}
//1.산술평균 sum/n
//2.중앙값은 정렬 후 a[n/2]
//3. 최빈값은 인덱스 ++;하고 ++된 수를 배열에 넣고 그배열을 정렬하고 2번째 수 출력if조건하나더 추가
//4. 범위: a[n-1]-a[0]