#include<bits/stdc++.h>
using namespace std;  
typedef long long ll; 

const int INF = 1e9; // 최대 -> 최소

int n, mp, mf, ms, mv; // n: 재료의 개수, mp: 최소 단백질, mf: 최소 지방, ms: 최소 탄수화물, mv: 최소 비타민

int b, c, d, e, ret = INF, sum; // b: 단백질의 합, c: 지방의 합, d: 탄수화물의 합, e: 비타민의 합, ret: 가장 작은 비용, sum: 현재 조합의 비용

struct A{ // 각 재료에 대한 정보를 담고 있는 구조체
    int mp, mf, ms, mv, cost; // mp: 단백질, mf: 지방, ms: 탄수화물, mv: 비타민, cost: 가격
}a[16]; 

map<int, vector<vector<int>>> ret_v; // 가장 적은 비용을 갖는 조합들을 저장할 맵 

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL); // 입출력 가속화를 위한 코드

    cin >> n; 
    cin >> mp >> mf >> ms >> mv; 

    for(int i = 0; i < n; i++){ // 각 재료에 대한 정보를 입력받음
        cin >> a[i].mp >> a[i].mf >> a[i].ms >> a[i].mv >> a[i].cost;  
    }

    for(int i = 1; i < (1 << n); i++){ // 모든 조합에 대해 검사
        b = c = d = e = sum = 0; // 초기화
        vector<int> v; // 현재 검사 중인 조합의 재료 번호들을 저장할 벡터 

        for(int j = 0; j < n; j++){
            if(i & (1 << j)){ // j번째 재료를 사용할 경우 
                v.push_back(j + 1); // 사용한 재료의 번호를 벡터에 추가 
                b += a[j].mp; // 단백질 합산 
                c += a[j].mf; // 지방 합산 
                d += a[j].ms; // 탄수화물 합산 
                e += a[j].mv; // 비타민 합산 
                sum += a[j].cost; // 가격 합산 
            }
        }

        if(b >= mp && c >= mf && d >= ms && e >= mv){ // 최소값을 만족할 경우 
            if(ret >= sum){ // 현재 조합의 비용이 현재 최소 비용보다 작거나 같은 경우 
                ret = sum; // 최소 비용 갱신 
                ret_v[ret].push_back(v); // 가장 작은 비용을 갖는 조합들을 맵에 추가 
            }
        }
    }

    if(ret == INF) cout << -1 << '\n'; // ret이갱신되지 않았으면 
    else{
        // 가장 작은 sum 값을 가진 조합을 출력하기 위해 sum 값에 따라 오름차순 정렬 -> 사전순도 자동으로 됨
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