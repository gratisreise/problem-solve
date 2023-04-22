#include<bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, mp, mf, ms, mv;
int b, c, d, e, ret = INF, sum;
struct A{
    int mp, mf, ms, mv, cost;
}a[16];
map<int, vector<vector<int>>> ret_v;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    cin >> mp >> mf >> ms >> mv;
    for(int i = 0; i < n; i++){
        cin >> a[i].mp >> a[i].mf >> a[i].ms >> a[i].mv >> a[i].cost;
    }
    for(int i = 1; i < (1 << n); i++){ // 재료없는 경우는 없으니깐
        b = c = d = e = sum = 0;
        vector<int> v;
        for(int j = 0; j < n; j++){
            if(i & (1 << j)){
                v.push_back(j + 1);
                b += a[j].mp;
                c += a[j].mf;
                d += a[j].ms;
                e += a[j].mv;
                sum += a[j].cost;
            }
        }
        if(b >= mp && c >= mf && d >= ms && e >= mv){
            if(ret >= sum){
                ret = sum;
                ret_v[ret].push_back(v); //ret가격 키에 벡터 저장
            }
        }
    }
    if(ret == INF) cout << -1 << '\n';
    else{
        sort(ret_v[ret].begin(), ret_v[ret].end()); //오름차순 정렬
        cout << ret << '\n'; // 가격 출력
        for(int a : ret_v[ret][0]){ // ret가격 값중 가장 첫 번째
            cout << a << " ";
        }
    }
    return 0;
}
/*
비트 연산자 이용한 반복 돌리기 부분 잘 모름 -> j이용하기 -> 있다없다 정해주니깐

*/