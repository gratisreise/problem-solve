#include <bits/stdc++.h>
using namespace std;
int main(){
    int c,n,s[1001];
    double ans;
    cin>>c;
    for(int i=0;i<c;i++){
        cin>>n;
        int avg=0;
        for(int j=0;j<n;j++){
            cin>>s[j];
            avg+=s[j];
        }
        avg/=n;
        double cnt=0;
        for(int k=0;k<n;k++){
            if(s[k]>avg){
                cnt++;
            }
        }
        ans=cnt/(double)n*100;
        cout<<fixed;
        cout.precision(3);
        cout<<ans<<"%"<<"\n";
    }
}
/*
1. 테스트 갯수 입력받음
2. 학생 수 입력받고 학생 수 만큼 점수입력받음
3. 평균을 내고 그 평균이랑 학생들 점수랑 비교하면서 평균보다 많은 사람 세기
4. 다중 반복문에서는 초기화의 시점주의!!
*/