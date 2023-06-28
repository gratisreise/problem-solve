#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, m, k, t1, t2, t3;
ll t4;
ll sum(vector<ll> &tree, int i){ // sum(query)
    ll ans = 0;
    while(i > 0){
        ans += tree[i];
        i -= (i & -i);
    }
    return ans;
}
void update(vector<ll> &tree, int i, ll diff){ // 업데이트 
    while(i < tree.size()){
        tree[i] += diff;
        i += (i & -i);
    }
}
int main(){
    scnaf("%d %d %d", &n, &m, &k);
    vector<ll> a(n+1);
    vector<ll> tree(n+1);
    for(int i = 1; i <= n; i++){
        scanf("%lld", &a[i]);
        update(tree, i, a[i]);
    }
    m += k; // m+k번만큼 숫자 변화 or 구간합 일어남
    while(m--){
        scanf("%d", &t1);
        if(t1 == 1){ // 숫자변화
            scanf("%d %d %d", &t2, &t4);
            ll diff = t4 - a[t2];
            a[t2] = t4;
            update(tree, t2, diff);
        }else{ // 구간합
            int t2, t3;
            scanf("%d %d", &t2, &t3);
            printf("%lld\n", sum(tree, t3) - sum(tree, t2 - 1));
        }
    }
}
/*
1. 트리구조는 이진 트리기반 자료구조
2. 구간합
*/