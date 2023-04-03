// 순열
makePermuatation(3, 3, 0);
void makePermutation(int n, int r, int depth){
    if(r == depth){
        printV(v);
        return;
    }
    cout << n << " : " << r << " : " << depth << '\n';
    for(int i = depth; i < n; i++){
        swap(v[i], v[depth]); // 교체 투입
        makePermutation(n, r, depth + 1); //다르게 들어갈 매개변수
        swap(v[i], v[depth]); // 원상복구
    }
    return;
}

//조합코드
void combi(int start, vector<int> b){
    if(b.size() == k){ //뽑을 갯수 k
        print(b);
        return;
    }
    for(int i = start + 1; i < n; i++){ // n개중에서 
        b.push_back(i);
        combi(i, b);
        b.pop_back();
    }
    return;
}

//팩토리얼
int fact(int n){
    if(n == 1 || n == 0) return  1;
    return n * fact(n - 1);
}
int fact1(int n){
    int ret = 1;
    for(int i = 1; i <= n; i++){
        ret *= i;
    }
    return ret;
}
//피보나치
int fibo(int n){
    if(n == 0 || n == 1) return n;
    return fibo(n - 1) + fibo(n - 2);
}