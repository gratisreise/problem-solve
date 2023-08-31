// O(nlogn)
#include <bits/stdc++.h>
using namespace std; 
int n, lis[1004], len, num;
int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++){
        scanf("%d", &num);
        auto lowerPos = lower_bound(lis, lis + len, num);
        if(*lowerPos == 0) len++;
        *lowerPos = num; 
    }
	printf("%d\n", len); 
	return 0;
} 
// O(n^2)
#include <bits/stdc++.h> 
int n, a[1004], cnt[1004], ret; 
using namespace std;  
int main(){
    cin >> n; 
    for(int i = 0; i < n; i++){
        cin >> a[i];
    } 
    for(int i = 0; i < n; i++){
        int mx = 0; 
        for(int j = 0; j < i; j++){
            if(a[j] < a[i] && mx < cnt[j]) mx = cnt[j];
        }
        cnt[i] = mx + 1; 
        ret = max(ret, cnt[i]);
    }
    cout << ret << "\n"; 
}