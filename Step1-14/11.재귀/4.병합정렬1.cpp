#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(0), cin.tie(0), cout.tie(0)
using namespace std;

void merge_sort(int* A, int start, int end, int K);
void merge(int* A, int p, int q, int r, int K);
int inputcnt = 0;

int main(){
    fastio;
    int N, K;
    cin >> N >> K;
    int* A;
    A = new int[N];
    for(int i=0; i<N; i++)
        cin >> A[i];
    merge_sort(A,0,N-1,K);
    if(inputcnt<K) cout << -1;
    // for(int i=0; i<N; i++)		//정렬 확인용 출력 
    //     cout << A[i] << " ";
    return 0;
}

void merge_sort(int* A, int start, int end, int K){
    int p = start, r = end, q;
    if(p<r){
        q = (p+r)/2;
        merge_sort(A,p,q,K);
        merge_sort(A,q+1,r,K);
        merge(A,p,q,r,K);
    }
}

void merge(int* A, int p, int q, int r, int K){
    int tmp[r+2];   //tmp배열은 인덱스 1부터 사용
    int i = p, j = q+1, t = 1;
    while(i<=q && j<=r){
        if(A[i]<=A[j])
            tmp[t++] = A[i++];
        else
            tmp[t++] = A[j++];
    }
    while(i<=q)
        tmp[t++] = A[i++];
    while(j<=r)
        tmp[t++] = A[j++];
    i = p, t = 1;
    while(i<=r){
        A[i++] = tmp[t++];
        if(++inputcnt==K)   cout << tmp[t-1];
    }
}