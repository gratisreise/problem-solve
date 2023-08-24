//순열
#include <bits/stdc++.h>
using namespace std;
int a[9];
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    for(int i =0;i<9;i++){
        cin>>a[i];
    }
    sort(a,a+9);
    do{
        int sum = 0;
        for(int i = 0;i<7;i++) sum +=a[i];
        if(sum == 100)break;
    }while(next_permutation(a,a+9));
    for(int i = 0; i<7;i++) cout<<a[i]<<'\n';
    return 0;
}

//조합
#include <bits/stdc++.h>
using namespace std;
int a[9],sum;
vector<int>v;
pair<int,int> ret;
void solve(){
    for(int i = 0;i<9;i++){
        for(int j = 0;j<i;j++){
            if(sum - a[i] - a[j]==100){
                ret = {i,j};
                return;
            }
        }
    }
}
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    for(int i = 0; i < 9;i++){
        cin >> a[i]; sum += a[i];
    }
    solve();
    for(int i = 0; i < 9; i++){
        if(ret.first == i || ret.second == i) continue; 
        v.push_back(a[i]);
    }
    sort(v.begin(),v.end());
    for(int i : v) cout << i <<" ";
    return 0;
}
/*
1. 조합, 순열
2. 정렬함수 sort
3. 

*/