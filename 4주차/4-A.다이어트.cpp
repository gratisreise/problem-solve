#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1e9;
int n, mp, mf, ms, mv;
int b, c, d, e, ret = INF, sum; // ret: 가장 적은 비용의 식단 비용, sum :식단 비용
struct A{
    int mp, mf, ms, mv, cost;
}a[16]; // 최대 16개의 식재료 정보를 담을 구조체 배열
map<int, vector<vector< int>>> ret_v; // 가장 적은 비용의 식단들을 모아둘 벡터를 map에 저장
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n;
    cin >> mp >> mf >> ms >> mv;
    for(int i = 0; i < n; i++){ //식재료들의 양과 비용을 입력
        cin >> a[i].mp >> a[i].mf >> a[i].ms >> a[i].mv >> a[i].cost;
    }
    for(int i = 1; i < (1 << n); i++){ //1~2^n-1까지의 모든 수를 확인하며 가능한 모든 식단 만듬
        b = c = d = e = sum = 0;
        vector<int> v;
        for(int j = 0; j < n; j++){
            if(i & (1 << j)){// i의 j번째 비트가 1이라면 j번째 식재료를 사용하겠다는 뜻
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
                ret_v[ret].push_back(v);
            }
        }
    }
    if(ret == INF) cout << -1 << '\n';
    else{
        sort(ret_v[ret].begin(), ret_v[ret].end());
        cout << ret << '\n';
        for(int a : ret_v[ret][0]){
            cout << a << " ";
        }
    }
    return 0;
}

/*
1. 하한값 이상의 조합을 만들어 낸다.
2. 오름차순 출력한다.
3. 가격이 키인 곳에서 여러가지 조합의 값을 넣는다.
*/