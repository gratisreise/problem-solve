#include<bits/stdc++.h>
using namespace std;
int n, sum, a, ret = -1001;
int main(){
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%d", &a);
        sum += a;
        ret = max(ret, sum);
        if(sum < 0) sum  = 0;
    }
    printf("%d\n", ret);
    return 0;
}
/*
만약 sum이 0보다 작아진다면, 이전에 입력받은 숫자들을 더하는 것보다 현재 숫자부터 
다시 더하는 것이 더 큰 값을 구할 수 있기 때문에 sum을 0으로 초기화해줍니다.
*/