<최소공배수, 최대공약수>
int gcd(int a, int b){
    if(a == 0) return b;
    return gcd(b % a, a);
}
int lcm(int a, int b){
    return (a * b) / gcd(a, b);
}

<에라토스테네스의 체>
배열을 선언하고 사용해줘야해서 공간의 제약있음
vector<int> era(int mx_n){
    vector<int> v;
    for(int i = 2; i <= mx_n; i++){
        if(che[i]) continue;
        for(int j = 2 * i; j <= mx_n; j += i){
            che[j] = 1;
        }
    }
    for(int = 2; i <= mx_n; i++) if(che[i] == 0) v.push_back(i);
    return v;
}
<논리형 소수체크>
bool check(int n){
    if(n <= 1) return 0;
    if(n == 2) return 1;
    if(n % 2 == 0) return 0;
    for(int i = 2; i * i <= n; i++){
        if(n % i == 0) return 0;
    }
}

오름차순열 : next_permutation(v.begin(), v.end());
내림차순열 : prev_permutation(v.begin(), v.end());

nPr
void makePermutation(int n, int r, int depth){
    if(r == depth){
        print();
        return;
    }
    for(int i = depth; i < n; i++){
        swap(a[i], a[depth]);
        makePermutation(n, r, depth + 1);
        swap(a[i], a[depth]);
    }
    return;
}