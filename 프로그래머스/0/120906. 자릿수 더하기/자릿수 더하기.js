function solution(n) {
    var ret = 0;
    while(n > 0){
        ret += n % 10;
        n = Math.floor(n /10);
    }
    return ret;
}