<쿼드트리>
string quard(int y, int x, int n){
    if(n == 1) return string(1, a[y][x]); //기저사례 + 캐릭터를 스트링으로 바꾸는 함수
    char b = a[y][x]; // char 
    string ret = ""; // 빈문자열로 초기화
    for(int i = y; i < y + n; i++){  // 분할정복 개념들어감
        for(int j = x; j < x + n; j++){
            if(b != a[i][j]){ // 같은 문자가 아닌게 있으면 바로 쪼개기
                ret += '(';
                ret += quard(y, x, n / 2); //왼쪽 위 
                ret += quard(y, x + n / 2, n / 2); // 오른쪽 위
                ret += quard(y + n / 2, x, n / 2); // 왼쪽 아래
                ret += quard(y + n / 2, x + n / 2, n / 2); // 오른쪽 아래
                ret += ')';
                return ret;
            }
        }
    }
    return string(1, a[y][x]); // 모두다 같은 문자일 때
}

