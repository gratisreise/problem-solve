#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
ll n, atk, t, a, h, H, mx, damage;
int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    cin >> n >> atk;
    for(int i = 0; i < n; i++){
        cin >> t >> a >> h;
        if(t == 1){ //몬스터와 전투
            damage = a *( ceil((double)h / atk) - 1);
            if(H < damage){
                mx += damage - H;
                H = 0;
            }else H -= damage;
        }else{ // 공증, 회복
            atk += a;
            H = min(H + h, mx);
        }
    }
    cout << mx + 1 << '\n';
}