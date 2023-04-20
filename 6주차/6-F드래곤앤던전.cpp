//BS
#include<bits/stdc++.h>
using namespace std; 
typedef long long ll;      
ll n, attack, t[130005], a[130005], h[130005], lo, hi, ret; 
void fastIO(){
	ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
}   
bool check(ll mid){
	ll mxHP = mid;
	ll init_attack = attack;  
	for(int i = 0; i < n; i++){
		if(t[i] == 2){
			mid = min(mxHP, mid + h[i]);
			init_attack += a[i];
		}else{
			ll cnt = h[i] / init_attack + (h[i] % init_attack ? 1 : 0); 
			mid -= (cnt - 1) * a[i];
		}   
		if(mid <= 0) return false;
	}
	return true; 
}
int main(){ 
	fastIO();
	cin >> n >> attack;  
	for(int i = 0; i < n; i++){
		cin >> t[i] >> a[i] >> h[i]; 
	}  
	lo = 1, hi = 1e18 + 4; 
	while(lo <= hi){
		ll mid = (lo + hi) / 2; 
		if(check(mid)){
			hi = mid - 1; 
			ret = mid;
		}else lo = mid + 1; 
	}  
    cout << ret << '\n'; 
	return 0;
}

// 그리디
#include<bits/stdc++.h>
using namespace std;
typedef long long ll;

ll n, atk, t, a, h, H, mx, damage;

int main(){
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    cin >> n >> atk; // n: 몬스터의 수, atk: 기본 공격력
    
    for(int i = 0; i < n; i++){
        cin >> t >> a >> h; // t: 몬스터의 유형, a: 몬스터의 공격력, h: 몬스터의 생명력
        
        if(t == 1){ // 일반 몬스터
            damage = a * (ceil((double)h / atk) - 1); // 공격을 가하는데 필요한 데미지
            if(H < damage){ // 만약 자신의 체력이 공격에 필요한 데미지보다 작다면
                mx += damage - H; // 회복 가능한 체력에서 데미지를 빼서 최대 회복 가능한 체력에 더해줌
                H = 0; // 자신의 체력은 0이 됨
            }else{
                H -= damage; // 그렇지 않으면 데미지만큼 자신의 체력을 깎음
            }
        }else{ // 회복과 공증
            atk += a; // 공격력을 증가시킴
            H = min(H + h, mx); // 회복가능한 체력이 mx를 못 넘게
        }
    }
    
    cout << mx + 1 << '\n'; // 최대 회복 가능한 체력에 1을 더한 값을 출력
    return 0;
}
//