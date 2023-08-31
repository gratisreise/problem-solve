#include <bits/stdc++.h>
using namespace std;

int main(){
    int num,sum=0; 
    cin>>num;
    int *k = new int[num];
    int *n = new int[num];
    int people[15][14] = {0,};
    for(int i =0; i<14;i++) people[0][i] = i+1;
    for(int i=0;i<14;i++){
        for(int j=0;j<14;j++){
            sum+=people[i][j];
            people[i+1][j] = sum;
        }
        sum =0;
    }
    for (int i =0;i<num;i++){
        cin>>k[i];
        cin>>n[i];
    }
    for(int i=0; i<num;i++){
        cout<< people[k[i]][n[i]-1]<<'\n';
    }
    return 0;
}   