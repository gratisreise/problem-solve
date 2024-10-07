function solution(my_string) {
    let ret = 0;
    for(var c of my_string){
        if('0' <= c && c <= '9') ret += c - '0';
    }
    return ret;
}