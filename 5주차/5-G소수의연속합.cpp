#include <bits/stdc++.h>
using namespace std;  
bool che[4000001];
int n, a[2000001], p, lo, hi, ret, sum; 
int main(){
	scanf("%d", &n); 
    for(int i = 2; i <= n; i++){ //에라토스테네스의 체를 이용해 소수 판별
		if(che[i]) continue;
		for(int j = 2 * i; j <= n; j += i){
			che[j] = 1;
		}
	}
	for(int i = 2; i <= n; i++){
		if(!che[i]) a[p++] = i; //소수만 배열에 담아줌
	}  
    while(1){
        if(sum >= n) sum -= a[lo++]; //sum이 n 이상이면 lo인덱스를 이동시켜서 작게 만들어줌
        else if(hi == p)break; // hi 인덱스가 배열 범위를 벗어나면 루프 탈출
        else sum += a[hi++]; // sum이 n미만일 경우 hi 인덱스를 이동 시켜서 크게 만들어줌
        if(sum == n) ret++; // 만약 sum이 n과 같다면 개수 증가
    } 
    printf("%d\n", ret); 
}
/*
에라토스테네스의 체를 이용해 n 이하의 소수를 찾아서 배열 a에 저장합니다.
lo와 hi 인덱스를 사용해서 구간 합을 구합니다.
sum이 n 이상이면 lo 인덱스를 이동시켜서 작게 만들어주고, 
sum이 n 미만일 경우 hi 인덱스를 이동시켜서 크게 만들어줍니다.
만약 sum이 n과 같다면 개수를 증가시킵니다.
*/