#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n, m, k, t1, t2, t3;
ll t4;

// 펜윅 트리에서 특정 인덱스까지의 합을 구하는 함수
ll sum(vector<ll> &tree, int i){
    ll ans = 0;
    while(i > 0){
        ans += tree[i];
        i -= (i & -i);
    }
    return ans;
}

// 펜윅 트리에서 특정 인덱스의 값을 갱신하는 함수
void update(vector<ll> &tree, int i, ll diff){
    while(i < tree.size()){
        tree[i] += diff;
        i += (i & -i);
    }
}

int main(){
    scnaf("%d %d %d", &n, &m, &k);
    vector<ll> a(n+1); // 입력받은 숫자를 저장할 배열
    vector<ll> tree(n+1); // 펜윅 트리 배열

    // 배열의 각 위치에 대해 초기값을 입력받고 펜윅 트리를 업데이트한다.
    for(int i = 1; i <= n; i++){
        scanf("%lld", &a[i]);
        update(tree, i, a[i]);
    }

    m += k; // m+k번만큼 숫자 변화 또는 구간합이 발생한다.
    while(m--){
        scanf("%d", &t1);
        if(t1 == 1){ // 숫자변화
            scanf("%d %d", &t2, &t4); 
            ll diff = t4 - a[t2]; // 변화한 값의 차이를 계산한다.
            a[t2] = t4; // 배열의 해당 위치를 갱신한다.
            update(tree, t2, diff); // 펜윅 트리를 업데이트한다.
        }else{ // 구간합
            int t2, t3;
            scanf("%d %d", &t2, &t3);
            printf("%lld\n", sum(tree, t3) - sum(tree, t2 - 1)); // 두 인덱스의 구간합을 출력한다.
        }
    }
}